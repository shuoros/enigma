package com.github.shuoros.enigma;

import com.github.shuoros.enigma.alphabet.Languages;
import com.github.shuoros.enigma.key.TripleDes;
import com.github.shuoros.enigma.utils.Reflector;
import com.github.shuoros.enigma.utils.Rotor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class Enigma {

    private Rotor[] rotors;
    private Reflector reflector;
    private int state;

    public Enigma(Languages language) {
        this(3, language);
    }

    public Enigma(int rotorCount, Languages language) {
        state = 0;
        rotors = new Rotor[rotorCount];
        for (int i = 0; i < rotorCount; i++) {
            rotors[i] = new Rotor(language);
        }
        reflector = new Reflector(language);
    }

    public Enigma(Rotor[] rotors, Reflector reflector) {
        state = 0;
        this.rotors = rotors;
        this.reflector = reflector;
    }

    public Enigma(String configFile) {
        File file = new File(configFile);
        StringBuilder sb = extractFromJSON(file);
        assert sb != null;
        String decrypted = decryptJSON(sb);
        JSONObject json = new JSONObject(decrypted);
        Rotor[] rotors = extractRotors(json);
        Reflector reflector = new Reflector(extractArrayFromJsonArray(json.getJSONArray("reflector")));
        this.rotors = rotors;
        this.reflector = reflector;
    }

    public static void init(Languages language, int rotorCount) {
        Enigma enigma = new Enigma(rotorCount, language);
        JSONObject json = insertToJSON(language, enigma);
        String encrypted = encryptJson(json);
        writeToFile(encrypted);
    }

    public char[] encrypt(char[] input) {
        char[] output = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            state++;
            output[i] = enigma(input[i]);
            shiftRotors();
        }
        return output;
    }

    private static String encryptJson(JSONObject json) {
        String encrypted = "Error in init";
        try {
            TripleDes td = new TripleDes();
            encrypted = td.encrypt(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }


    private static void writeToFile(String encrypted) {
        try {
            FileWriter myWriter = new FileWriter("key.enigma");
            myWriter.write(encrypted);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private char enigma(char c) {
        char rotated = rotateRotors(c);
        char reflected = reflect(rotated);
        return reverseRotateRotors(reflected);
    }

    private char reverseRotateRotors(char reverseRotated) {
        for (int j = rotors.length - 1; j >= 0; j--) {
            reverseRotated = rotors[j].reverseRotate(reverseRotated);
        }
        return reverseRotated;
    }

    private char reflect(char rotated) {
        return reflector.reflect(rotated);
    }

    private char rotateRotors(char c) {
        char rotated = c;
        for (Rotor rotor : rotors) {
            rotated = rotor.rotate(rotated);
        }
        return rotated;
    }

    private void shiftRotors() {
        rotors[0].shift();
        for (int i = 1; i < rotors.length; i++) {
            if (state % Math.pow(rotors[i].size(), i) == 0) {
                rotors[i].shift();
            }
        }
    }

    private static JSONObject insertToJSON(Languages language, Enigma enigma) {
        JSONObject json = new JSONObject();
        json.put("language", language.toString());
        JSONArray rotors = new JSONArray();
        for (Rotor rotor : enigma.rotors) {
            rotors.put(rotor.me());
        }
        json.put("rotors", rotors);
        json.put("reflector", enigma.reflector.me());
        return json;
    }

    private StringBuilder extractFromJSON(File file) {
        StringBuilder sb = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            sb = new StringBuilder();
            String st;
            while ((st = br.readLine()) != null)
                sb.append(st);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    private String decryptJSON(StringBuilder sb) {
        String decrypted = "";
        try {
            TripleDes td = new TripleDes();
            decrypted = td.decrypt(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypted;
    }

    private Rotor[] extractRotors(JSONObject json) {
        Rotor[] rotors = new Rotor[json.getJSONArray("rotors").length()];
        for (int i = 0; i < rotors.length; i++) {
            rotors[i] = new Rotor(extractArrayFromJsonArray(json.getJSONArray("rotors").getJSONArray(i)),//
                    Languages.valueOf(json.getString("language")));
        }
        return rotors;
    }

    private char[] extractArrayFromJsonArray(JSONArray rotor) {
        char[] result = new char[rotor.length()];
        for (int i = 0; i < rotor.length(); i++) {
            result[i] = rotor.getString(i).charAt(0);
        }
        return result;
    }

}
