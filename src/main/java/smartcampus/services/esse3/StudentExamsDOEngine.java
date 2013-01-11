package smartcampus.services.esse3;

import it.sayservice.platform.core.domain.common.exception.DomainDataHandlerException;
import it.sayservice.platform.core.domain.DomainConst.DOMAIN_OBJECT_EVENT_TYPE;
import it.sayservice.platform.core.domain.DomainRelationTarget;
import it.sayservice.platform.core.domain.bundle.DomainEvent;
import it.sayservice.platform.core.domain.ext.AbstractDOEngineImpl;
import it.sayservice.platform.core.domain.ext.ActionInvoke;
import it.sayservice.platform.core.domain.ext.DomainObjectWrapper;
import it.sayservice.platform.core.domain.ext.LanguageHelper;
import it.sayservice.platform.core.domain.ext.Tuple;
import it.sayservice.platform.core.domain.rules.DomainSubscriptionRule;
import it.sayservice.platform.core.domain.rules.EvaluableDomainSubscriptionRule;
import it.sayservice.platform.core.domain.rules.EvaluableDomainOperation;
import it.sayservice.platform.core.domain.rules.DomainEventDescriptor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashMap;

import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;

public class StudentExamsDOEngine extends AbstractDOEngineImpl {

    public StudentExamsDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "_callback_storeExams1",
            "initialize",
            "storeExams",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAACdwQAAAACc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAV0AAlvcGVyYXRpb250AA9nZXRTdHVkZW50RXhhbXN0AAlzZXJ2aWNlSWR0ABlzbWFydGNhbXB1cy5zZXJ2aWNlLmVzc2UzdAAJY29udmVydGVydAA1c21hcnRjYW1wdXMuc2VydmljZXMuZXNzZTMuZGF0YS5TdHVkZW50RXhhbXNDb252ZXJ0ZXJ0AAR0eXBldAAHU2VydmljZXQACm1ldGhvZE5hbWV0AA9HZXRTdHVkZW50RXhhbXN4c3EAfgACP0AAAAAAAAx3CAAAABAAAAAFcQB+AAR0ABVzdWJzY3JpYmVTdHVkZW50RXhhbXNxAH4ABnQAGXNtYXJ0Y2FtcHVzLnNlcnZpY2UuZXNzZTNxAH4ACHBxAH4ACnQADFN1YnNjcmlwdGlvbnEAfgAMdAAPR2V0U3R1ZGVudEV4YW1zeHg="));
    }

     public  Collection<java.io.Serializable> getExtensionValues(String property) {
        return extensions.get(property);
     }  
    
    protected Object executeAction(String actionName, DomainObjectWrapper obj, Tuple t, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        if ("_callback_storeExams1".equals(actionName)) {
            return _callback_storeExams1(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("initialize".equals(actionName)) {
            return initialize(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("storeExams".equals(actionName)) {
            return storeExams(t, obj, outEvents, ops, securityToken, bundleId);
        }
        return null;
    }

    private Object initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
{
Tuple body = new Tuple();
 body.put("idAda",getDomainObjectHandler().getVar("idAda",obj,java.lang.String.class,bundleId));
getDomainObjectHandler().invokeOperationWithCallback(obj, "getStudentExams", body, "_callback_storeExams1", "data", ops, bundleId);}
{
Tuple body = new Tuple();
 body.put("idAda",getDomainObjectHandler().getVar("idAda",obj,java.lang.String.class,bundleId));
getDomainObjectHandler().invokeOperation(obj, "subscribeStudentExams", body, ops, bundleId);}
}
return null;
}

    }
    private Object storeExams(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
smartcampus.services.esse3.data.ExamData[] data = (smartcampus.services.esse3.data.ExamData[]) tuple.get("data");
{
getDomainObjectHandler().setVar("examData", obj, data, evts, bundleId);}
return null;
}

    }
    
    private Object _callback_storeExams1(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
smartcampus.services.esse3.data.ExamData[] data = (smartcampus.services.esse3.data.ExamData[]) tuple.get("data");
{
Tuple body = new Tuple();
 body.put("data",data);
storeExams(body, obj, evts, ops, securityToken, bundleId);}
return null;
}

    }
    
    
    
    public void handleObjectRelUpdate(String rName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
    }
    public void handleObjectVarUpdate(String vName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
    }

    public void handleObjectCreate(DomainObjectWrapper obj, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String bundleId) throws DomainDataHandlerException {
        __initialize(new Tuple(), obj, outEvents, ops, obj.getDomainObject().getSecurityToken(),bundleId);
    }

    private Object __initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
{
Tuple body = new Tuple();
 body.put("idAda",getDomainObjectHandler().getVar("idAda",obj,java.lang.String.class,bundleId));
getDomainObjectHandler().invokeOperationWithCallback(obj, "getStudentExams", body, "_callback_storeExams1", "data", ops, bundleId);}
{
Tuple body = new Tuple();
 body.put("idAda",getDomainObjectHandler().getVar("idAda",obj,java.lang.String.class,bundleId));
getDomainObjectHandler().invokeOperation(obj, "subscribeStudentExams", body, ops, bundleId);}
}
return null;
}

    }

    protected ActionInvoke ruleApplies(EvaluableDomainSubscriptionRule rule, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        if ("declared_subscription_sub_0".equals(rule.getRule().getEngineName())) {
            Tuple payload = (Tuple) rule.getEvent().getPayload();
            smartcampus.services.esse3.data.ExamData[] data = (smartcampus.services.esse3.data.ExamData[]) payload.get("data");
            java.lang.String serviceIdAda = (java.lang.String) payload.get("serviceIdAda");
            String name = (String) payload.get("name");
            if (((true) && (name.equals("updateStudentExams"))) && (serviceIdAda.equals(getDomainObjectHandler().getVar("idAda",obj,java.lang.String.class,bundleId)))){
                Tuple tuple = new Tuple();
                tuple.put("data",data);
                return new ActionInvoke("storeExams", tuple);
            }
        }
        return null;
    }


    @Override
    public boolean isRelation(String key) {
        return false
        ;    
    }

    @Override
    public String getType() {
        return "smartcampus.services.esse3.StudentExams";
    }

    @Override
    public boolean isStatic() {
        return !true;
    }

    private static Collection<String> dependencies = new java.util.HashSet<String>();
    static {
        dependencies.add("smartcampus.services.esse3.StudentExamsService");
    }

    public Collection<String> getDependencies() {
        return dependencies;
    }

    public Collection<DomainSubscriptionRule> getSubscriptions(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> rules = new ArrayList<DomainSubscriptionRule>();
        
        {
            DomainSubscriptionRule 
            rule = new DomainSubscriptionRule();
            rule.setName("declared_subscription_sub_0");
            rule.setSourceId(null);
            rule.setSourceType("smartcampus.services.esse3.StudentExamsService");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("declared_subscription_sub_0");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CUSTOM .toString());
            rule.setEventSubtype("updateStudentExams");
            Map<String,Object> queryParams = _subscriptionFunction_declared_subscription_sub_0 (obj,bundleId); 
            if (queryParams != null) {
                if (!queryParams.isEmpty()) {
                    rule.setQueryParameters(queryParams);
                }
                rules.add(rule);
            }
        }
        return rules;
    }

    
    public it.sayservice.platform.domain.model.interfaces.DomainTypeInterface getInterface() throws it.sayservice.platform.core.domain.common.exception.DomainDataHandlerException {
        return smartcampus.services.esse3 .StudentExamsInterface .getInstance();
    }
    
    private java.util.Map<String,Object> _subscriptionFunction_declared_subscription_sub_0(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
            boolean pre = false;
    Map<String,Object> result = new HashMap<String,Object>();
    if (true) {
        pre = true;
    }
    result.putAll(QueryBuilder.start().and("p_m1561707734").is(getDomainObjectHandler().getVar("idAda",obj,java.lang.String.class,bundleId)).get().toMap());
    if (!pre) return null;
    return result;

    }

    private java.util.List<DomainSubscriptionRule> _subscriptionQuery_declared_subscription_sub_0(DomainEvent evt, String securityToken, String bundleId) throws DomainDataHandlerException {
        Tuple payload = (Tuple) evt.getPayload();
        smartcampus.services.esse3.data.ExamData[] data = (smartcampus.services.esse3.data.ExamData[]) payload.get("data");
        java.lang.String serviceIdAda = (java.lang.String) payload.get("serviceIdAda");
        String name = (String) payload.get("name");
            List<DBObject> queryList = new ArrayList<DBObject>();
    if (name.equals("updateStudentExams")) {
        queryList.add(QueryBuilder.start().and("queryParameters.p_m1561707734").is(serviceIdAda).get());
    }
    if (queryList.isEmpty()) return Collections.emptyList();
    return getDomainObjectHandler().querySubs(evt, "smartcampus.services.esse3.StudentExams", "declared_subscription_sub_0", QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);

    }

    public List<DomainSubscriptionRule> findSubscriptionRules(DomainEvent event, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> result = new ArrayList<DomainSubscriptionRule>();
        List<DomainSubscriptionRule> tmp = null;
        if (event.getAllTypes().contains("smartcampus.services.esse3.StudentExamsService")
            && DOMAIN_OBJECT_EVENT_TYPE.CUSTOM .equals(event.getEventType())
            && "updateStudentExams".equals(event.getEventSubtype())
            ) {
            tmp = _subscriptionQuery_declared_subscription_sub_0 (event, securityToken, bundleId);
            if (tmp != null && !tmp.isEmpty()) {
                result.addAll(tmp);
            }
        }   
        return result;
    }
    
    public Collection<DomainEventDescriptor> getEventsToQuery() {
        List<DomainEventDescriptor> result = new ArrayList<DomainEventDescriptor>();
        result.add(new DomainEventDescriptor(
            "smartcampus.services.esse3.StudentExamsService",
            DOMAIN_OBJECT_EVENT_TYPE.CUSTOM, 
            "updateStudentExams",
            null
            ));        
        return result;
    }
    
}


