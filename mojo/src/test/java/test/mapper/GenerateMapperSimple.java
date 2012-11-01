
package test.mapper;

import github.compile.mapper.source.InnerSourceClass1;
import github.compile.mapper.source.InnerSourceClass2;
import github.compile.mapper.source.InnerTargetClass1;
import github.compile.mapper.source.InnerTargetClass2;
import github.compile.mapper.source.SourceObject;
import github.compile.mapper.source.TargetObject;

public class GenerateMapperSimple {

    public SourceObject source;
    public TargetObject target;

    public void map() {
        mapTarget0();
    }

    public Object getValue0() {
        InnerSourceClass1 innersourceclass10;
        innersourceclass10 = ((InnerSourceClass1) source.getSrc1());
        if ((innersourceclass10==null)) {
            return null;
        }
        InnerSourceClass2 innersourceclass21;
        innersourceclass21 = ((InnerSourceClass2) innersourceclass10 .getSrc2());
        if ((innersourceclass21==null)) {
            return null;
        }
        String string2;
        string2 = ((String) innersourceclass21 .getSource());
        if ((string2==null)) {
            return null;
        }
        return string2;
    }

    public void mapTarget0() {
        InnerTargetClass1 innertargetclass10;
        innertargetclass10 = target.getTarget3();
        if (innertargetclass10 == null) {
            innertargetclass10 = new InnerTargetClass1();
            target.setTarget3(innertargetclass10);
        }
        InnerTargetClass2 innertargetclass21;
        innertargetclass21 = innertargetclass10 .getTg2();
        if (innertargetclass21 == null) {
            innertargetclass21 = new InnerTargetClass2();
            innertargetclass10 .setTg2(innertargetclass21);
        }
        Object value;
        String decl;
        value = getValue0();
        decl = ((String) value);
        innertargetclass21 .setTg3(decl);
    }

}