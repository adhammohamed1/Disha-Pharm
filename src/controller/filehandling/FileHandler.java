package controller.filehandling;


import java.io.BufferedWriter;
import java.io.IOException;

/**
 * This interface is responsible for file handling for all system objects.
 * The {@code FileHandler} interface contains <b>4</b> abstract methods:
 * <i>saveToFile()</i> ,
 * <i>loadFromFile()</i> ,
 * <i>loadInstance(String)</i>
 * &
 * <i>saveInstance(Object)</i>.
 *
 * @author Adham Mohamed Aly
 * @implNote It is advised to strictly manipulate encrypted data
 * and only decrypt user data when absolutely necessary.
 **/
public interface FileHandler {

    void saveToFile() throws IOException;

    boolean loadFromFile();

    void loadInstance(String line);

    void saveInstance(Object object, BufferedWriter writer);

}
