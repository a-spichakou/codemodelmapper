
package test.mapper;

import java.util.ArrayList;
import java.util.List;
import github.compile.mapper.source.InnerSourceClass1;
import github.compile.mapper.source.InnerSourceClass2;
import github.compile.mapper.source.InnerTargetClass1;
import github.compile.mapper.source.InnerTargetClass2;
import github.compile.mapper.source.SimpleConverter;
import github.compile.mapper.source.SourceObject;
import github.compile.mapper.source.TargetObject;

public class GenerateMapperConverter {

    public SourceObject source;
    public TargetObject target;
    public SimpleConverter converter;

    public void map() {
        map_target();
    }

    public List getParam() {
        List params = new ArrayList();
        params.add(getParam_0());
        return params;
    }

    public Object getParam_0() {
        String string0;
        string0 = source.getParam1();
        if ((string0==null)) {
            return null;
        }
        return string0;
    }

    public String convert() {
        if ((converter==null)) {
            return null;
        }
        Object value;
        value = getValue();
        String valueCasted;
        valueCasted = ((String) value);
        converter.convert(valueCasted, getParam());
        return converter.convert(valueCasted, getParam());
    }

    public Object getValue() {
        InnerSourceClass1 innersourceclass10;
        innersourceclass10 = source.getSrc1();
        if ((innersourceclass10==null)) {
            return null;
        }
        InnerSourceClass2 innersourceclass21;
        innersourceclass21 = innersourceclass10 .getSrc2();
        if ((innersourceclass21==null)) {
            return null;
        }
        String string2;
        string2 = innersourceclass21 .getSource();
        if ((string2==null)) {
            return null;
        }
        return string2;
    }

    public void map_target() {
        InnerTargetClass1 innertargetclass10;
        innertargetclass10 = target.getTarget3();
        if ((innertargetclass10==null)) {
            innertargetclass10 = new InnerTargetClass1();
            target.setTarget3(innertargetclass10);
        }
        InnerTargetClass2 innertargetclass21;
        innertargetclass21 = innertargetclass10 .getTg2();
        if ((innertargetclass21==null)) {
            innertargetclass21 = new InnerTargetClass2();
            innertargetclass10 .setTg2(innertargetclass21);
        }
        String value;
        String decl;
        value = convert();
        decl = ((String) value);
        innertargetclass21 .setTg3(decl);
    }

}
