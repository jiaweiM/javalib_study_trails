package tutorial.lib.picocli;

import org.testng.annotations.Test;
import picocli.CommandLine;

import static org.testng.Assert.*;

import java.io.File;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 19 Apr 2019, 1:14 PM
 */
public class MandatoryOption
{
    @CommandLine.Option(names = "-n", required = true, description = "mandatory number")
    int number;

    @CommandLine.Parameters
    File[] files;

    @Test
    public void test()
    {
        String[] args = {"file1", "file2", "file3"};
        MandatoryOption mandatoryOption = new MandatoryOption();
        assertThrows(CommandLine.MissingParameterException.class, () -> CommandLine.populateCommand(mandatoryOption, args));
    }
}
