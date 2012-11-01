
package test.mapper;

import github.compile.mapper.test.Source;
import github.compile.mapper.test.Target;

import java.util.Date;

public class BuildTestTreeDefaultValue0level {

    public Source source;
    public Target target;

    public void map() {
        mapTarget0();
        mapTarget1();
        mapTarget2();
    }

    public Integer getValue0() {
        return  99;
    }

    public void mapTarget0() {
        Integer value;
        Integer decl;
        value = getValue0();
        decl = ((Integer) value);
        target.setLevel0primitive(decl);
    }

    public String getValue1() {
        return "StringValue";
    }

    public void mapTarget1() {
        String value;
        String decl;
        value = getValue1();
        decl = ((String) value);
        target.setLevel0String(decl);
    }

    public Date getValue2() {
        return new Date(1351692922000L);
    }

    public void mapTarget2() {
        Date value;
        Date decl;
        value = getValue2();
        decl = ((Date) value);
        target.setLevel0Complex(decl);
    }

}
