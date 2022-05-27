package pbo.mod.pkg11;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public interface Email_IO {

    void save(ObjectOutput out) throws IOException;
    void load(ObjectInput input) throws IOException, ClassNotFoundException;

}
