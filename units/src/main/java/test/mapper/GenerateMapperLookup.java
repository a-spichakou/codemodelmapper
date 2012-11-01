
package test.mapper;

import github.compile.mapper.test1.InnerSourceClass1;
import github.compile.mapper.test1.InnerSourceClass2;
import github.compile.mapper.test1.InnerTargetClass1;
import github.compile.mapper.test1.InnerTargetClass2;
import github.compile.mapper.test1.SimpleLookup;
import github.compile.mapper.test1.SourceObject;
import github.compile.mapper.test1.TargetObject;


public class GenerateMapperLookup {

    public SourceObject source;
    public TargetObject target;
    public SimpleLookup lookup;

    public void map() {
        mapTarget00();
    }

    public String lookup_target() {
        if ((lookup==null)) {
            return null;
        }
        Object value;
        value = getValue();
        String valueCasted;
        valueCasted = ((String) value);
        lookup.lookup(valueCasted);
        return lookup.lookup(valueCasted);
    }

    public Object getValue() {
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

    public void mapTarget00() {
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
        String value;
        String decl;
        value = lookup_target();
        decl = ((String) value);
        innertargetclass21 .setTg3(decl);
    }

}
