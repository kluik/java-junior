package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.NullMessageException;
import com.acme.edu.PrintException;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    /*
    TODO: implement Logger solution to match specification as tests
    */
    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException, PrintException, NullMessageException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("3" + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws PrintException, NullMessageException {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.close();
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("10" + System.lineSeparator());
        assertSysoutContains(Integer.MAX_VALUE + "" + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws PrintException, NullMessageException {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log(Byte.MAX_VALUE);
        Logger.log("str 2");
        //Logger.close();
        //Logger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("10" + System.lineSeparator());
        assertSysoutContains(Byte.MAX_VALUE + "" + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        //assertSysoutContains("0" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException, PrintException, NullMessageException {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.close();
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("str 2 (x2)" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("str 3 (x3)" + System.lineSeparator());
        //endregion
    }
    //*/
    /*
    @Test
    public void shouldProcedureLogSequentIntegersAsSum() throws IOException {
        //region when
        ProcedureLogger.log("str 1");
        ProcedureLogger.log(1);
        ProcedureLogger.log(2);
        ProcedureLogger.log("str 2");
        ProcedureLogger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("3" + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldProcedureLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        ProcedureLogger.log("str 1");
        ProcedureLogger.log(10);
        ProcedureLogger.log(Integer.MAX_VALUE);
        ProcedureLogger.log("str 2");
        ProcedureLogger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("10" + System.lineSeparator());
        assertSysoutContains(Integer.MAX_VALUE + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldProcedureLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        ProcedureLogger.log("str 1");
        ProcedureLogger.log((byte)10);
        ProcedureLogger.log((byte)11);
        ProcedureLogger.log((byte)Byte.MAX_VALUE);
        ProcedureLogger.log((byte)Byte.MAX_VALUE);
        ProcedureLogger.log("str 2");
        ProcedureLogger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains(Byte.MAX_VALUE + System.lineSeparator());
        assertSysoutContains(Byte.MAX_VALUE + System.lineSeparator());
        assertSysoutContains("10" + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldProcedureLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        ProcedureLogger.log("str 1");
        ProcedureLogger.log("str 2");
        ProcedureLogger.log("str 2");
        ProcedureLogger.log(0);
        ProcedureLogger.log("str 2");
        ProcedureLogger.log("str 3");
        ProcedureLogger.log("str 3");
        ProcedureLogger.log("str 3");
        ProcedureLogger.FlushBuffer();
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("str 2 (x2)" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("str 3 (x3)" + System.lineSeparator());
        //endregion
    }
    //*/
}