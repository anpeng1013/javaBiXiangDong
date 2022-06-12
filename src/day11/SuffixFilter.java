package day11;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class SuffixFilter implements FilenameFilter{
    private String suffix;
    public SuffixFilter(String s) {
        super();
        this.suffix=s;
    }

    @Override
    public boolean accept(File dir, String name) {

        return name.endsWith(suffix);
    }
}
