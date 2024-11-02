import com.yupi.cli.example.SubCommandExample;
import org.junit.Test;
import picocli.CommandLine;

import static org.junit.Assert.assertEquals;

public class CommandLineTest {
    CommandLine commandLine = new CommandLine(new SubCommandExample())
            .addSubcommand(new SubCommandExample.AddCommand())
            .addSubcommand(new SubCommandExample.DeleteCommand())
            .addSubcommand(new SubCommandExample.QueryCommand());

    // 测试住命令
    @Test
    public void testMainCommand() {
        String args[] = new String[] {};
        int exitCode = commandLine.execute(args);
        assertEquals(0, exitCode);
    }

    // 测试帮助命令
    @Test
    public void testHelpCommand() {
        String args[] = new String[] {"--help"};
        int exitCode = commandLine.execute(args);
        assertEquals(0, exitCode);
    }

    // 测试增加子命令
    @Test
    public void testAddSubCommand() {
        String args[] = new String[] {"add"};
        int exitCode = commandLine.execute(args);
        assertEquals(0, exitCode);
    }
}
