package sample.rejectbom.controller;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class UsualCsvReaderTest {

    private List<String> assumList;
    private Path NON_BOM_CSV;
    private Path BOM_CSV;
    
    @Before
    public void setup() {
        assumList = new ArrayList<String>();
        assumList.add("id,value");
        assumList.add("1,hoge");
        assumList.add("2,piyo");
        assumList.add("3,ふが");

        NON_BOM_CSV = 
            Paths.get(
                Thread.currentThread()
                      .getContextClassLoader()
                      .getResource("non_bom.csv") // resources下のファイルパスを指定する。
                      .getPath()
            );

        BOM_CSV = 
            Paths.get(
                Thread.currentThread()
                      .getContextClassLoader()
                      .getResource("bom.csv") // resources下のファイルパスを指定する。
                      .getPath()
            );
            
    }
    
    @Test
    public void nonBomCsvRead() throws IOException {
        assertThat(UsualCsvReader.read(NON_BOM_CSV.toString()), is(assumList));
    }
    
    @Test
    public void bomCsvRead() throws IOException {
        assertThat(UsualCsvReader.read(BOM_CSV.toString()), is(not(assumList)));
    }
    
}