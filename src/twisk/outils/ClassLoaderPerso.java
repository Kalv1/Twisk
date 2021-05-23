package twisk.outils;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings("deprecation")
public class ClassLoaderPerso extends ClassLoader {

    public ClassLoaderPerso(ClassLoader parent) {
        super(parent);
    }

    /**
     * Chargement dans le classLoader de la classe, si c'est la classe Simulation qui est demandée, alors on va directement lire cette classe
     * à partir du fichier .class et on la conserve dans le ClassLoader personnel
     *
     * @param name nom complétement spécifié de la classe à charger
     * @return la classe chargée
     */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("twisk.simulation.Simulation")) {
            return getClass(name);
        }
        return super.loadClass(name);
    }

    /**
     * Chargement de la classe à partir du fichier .class
     *
     * @param name nom du fichier .class
     * @return la classe chargée
     */
    private Class<?> getClass(String name) {
        String file = name.replace('.', File.separatorChar) + ".class";

        byte[] byteArr;
        try {
            // Chargement de byte code du fichier de la classe
            byteArr = loadClassData(file);

            Class<?> c = defineClass(name, byteArr, 0, byteArr.length);
            resolveClass(c);
            System.out.println("\nLa classe retournée : " + c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Chargement du fichier .class converti en tableau de bytes.
     *
     * @param name nom du fichier .class
     * @return tableau de bytes
     */
    private byte[] loadClassData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        assert stream != null;
        int size = stream.available();
        byte[] buff = new byte[size];
        DataInputStream in = new DataInputStream(stream);

        // lecture des données binaires
        in.readFully(buff);
        in.close();
        return buff;
    }

    public void finalize() {
        System.out.println("..................................................................................................ClassLoaderPerso : A garbage collected");
    }

}