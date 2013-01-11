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

public class StudentInfoDOEngine extends AbstractDOEngineImpl {

    public StudentInfoDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "_callback_storeInfo3",
            "_callback_storeInfo4",
            "forceUpdate",
            "initialize",
            "storeInfo",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAADdwQAAAADc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAN0AAlvcGVyYXRpb250AAtmb3JjZVVwZGF0ZXQACmFjdGlvbk5hbWV0AAtmb3JjZVVwZGF0ZXQABHR5cGV0AAVMb2NhbHhzcQB+AAI/QAAAAAAADHcIAAAAEAAAAAVxAH4ABHQADmdldFN0dWRlbnREYXRhdAAJc2VydmljZUlkdAAZc21hcnRjYW1wdXMuc2VydmljZS5lc3NlM3QACWNvbnZlcnRlcnQANHNtYXJ0Y2FtcHVzLnNlcnZpY2VzLmVzc2UzLmRhdGEuU3R1ZGVudERhdGFDb252ZXJ0ZXJxAH4ACHQAB1NlcnZpY2V0AAptZXRob2ROYW1ldAAOR2V0U3R1ZGVudERhdGF4c3EAfgACP0AAAAAAAAx3CAAAABAAAAAFcQB+AAR0ABRzdWJzY3JpYmVTdHVkZW50RGF0YXEAfgAMdAAZc21hcnRjYW1wdXMuc2VydmljZS5lc3NlM3EAfgAOcHEAfgAIdAAMU3Vic2NyaXB0aW9ucQB+ABF0AA5HZXRTdHVkZW50RGF0YXh4"));
    }

     public  Collection<java.io.Serializable> getExtensionValues(String property) {
        return extensions.get(property);
     }  
    
    protected Object executeAction(String actionName, DomainObjectWrapper obj, Tuple t, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        if ("_callback_storeInfo3".equals(actionName)) {
            return _callback_storeInfo3(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_callback_storeInfo4".equals(actionName)) {
            return _callback_storeInfo4(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("forceUpdate".equals(actionName)) {
            return forceUpdate(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("initialize".equals(actionName)) {
            return initialize(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("storeInfo".equals(actionName)) {
            return storeInfo(t, obj, outEvents, ops, securityToken, bundleId);
        }
        return null;
    }

    private Object forceUpdate(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
{
Tuple body = new Tuple();
 body.put("idAda",getDomainObjectHandler().getVar("idAda",obj,java.lang.String.class,bundleId));
getDomainObjectHandler().invokeOperationWithCallback(obj, "getStudentData", body, "_callback_storeInfo3", "data", ops, bundleId);}
}
return null;
}

    }
    private Object initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
{
Tuple body = new Tuple();
 body.put("idAda",getDomainObjectHandler().getVar("idAda",obj,java.lang.String.class,bundleId));
getDomainObjectHandler().invokeOperationWithCallback(obj, "getStudentData", body, "_callback_storeInfo4", "data", ops, bundleId);}
{
Tuple body = new Tuple();
 body.put("idAda",getDomainObjectHandler().getVar("idAda",obj,java.lang.String.class,bundleId));
getDomainObjectHandler().invokeOperation(obj, "subscribeStudentData", body, ops, bundleId);}
}
return null;
}

    }
    private Object storeInfo(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
smartcampus.services.esse3.data.StudentData data = (smartcampus.services.esse3.data.StudentData) tuple.get("data");
{
getDomainObjectHandler().setVar("studentData", obj, data, evts, bundleId);}
return null;
}

    }
    
    private Object _callback_storeInfo3(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
smartcampus.services.esse3.data.StudentData data = (smartcampus.services.esse3.data.StudentData) tuple.get("data");
{
Tuple body = new Tuple();
 body.put("data",data);
storeInfo(body, obj, evts, ops, securityToken, bundleId);}
return null;
}

    }
    private Object _callback_storeInfo4(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
smartcampus.services.esse3.data.StudentData data = (smartcampus.services.esse3.data.StudentData) tuple.get("data");
{
Tuple body = new Tuple();
 body.put("data",data);
storeInfo(body, obj, evts, ops, securityToken, bundleId);}
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
getDomainObjectHandler().invokeOperationWithCallback(obj, "getStudentData", body, "_callback_storeInfo4", "data", ops, bundleId);}
{
Tuple body = new Tuple();
 body.put("idAda",getDomainObjectHandler().getVar("idAda",obj,java.lang.String.class,bundleId));
getDomainObjectHandler().invokeOperation(obj, "subscribeStudentData", body, ops, bundleId);}
}
return null;
}

    }

    protected ActionInvoke ruleApplies(EvaluableDomainSubscriptionRule rule, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        if ("declared_subscription_sub_0".equals(rule.getRule().getEngineName())) {
            Tuple payload = (Tuple) rule.getEvent().getPayload();
            smartcampus.services.esse3.data.StudentData data = (smartcampus.services.esse3.data.StudentData) payload.get("data");
            java.lang.String serviceIdAda = (java.lang.String) payload.get("serviceIdAda");
            String name = (String) payload.get("name");
            if (((true) && (name.equals("updateStudentData"))) && (serviceIdAda.equals(getDomainObjectHandler().getVar("idAda",obj,java.lang.String.class,bundleId)))){
                Tuple tuple = new Tuple();
                tuple.put("data",data);
                return new ActionInvoke("storeInfo", tuple);
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
        return "smartcampus.services.esse3.StudentInfo";
    }

    @Override
    public boolean isStatic() {
        return !true;
    }

    private static Collection<String> dependencies = new java.util.HashSet<String>();
    static {
        dependencies.add("smartcampus.services.esse3.StudentDataService");
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
            rule.setSourceType("smartcampus.services.esse3.StudentDataService");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("declared_subscription_sub_0");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CUSTOM .toString());
            rule.setEventSubtype("updateStudentData");
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
        return smartcampus.services.esse3 .StudentInfoInterface .getInstance();
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
        smartcampus.services.esse3.data.StudentData data = (smartcampus.services.esse3.data.StudentData) payload.get("data");
        java.lang.String serviceIdAda = (java.lang.String) payload.get("serviceIdAda");
        String name = (String) payload.get("name");
            List<DBObject> queryList = new ArrayList<DBObject>();
    if (name.equals("updateStudentData")) {
        queryList.add(QueryBuilder.start().and("queryParameters.p_m1561707734").is(serviceIdAda).get());
    }
    if (queryList.isEmpty()) return Collections.emptyList();
    return getDomainObjectHandler().querySubs(evt, "smartcampus.services.esse3.StudentInfo", "declared_subscription_sub_0", QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);

    }

    public List<DomainSubscriptionRule> findSubscriptionRules(DomainEvent event, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> result = new ArrayList<DomainSubscriptionRule>();
        List<DomainSubscriptionRule> tmp = null;
        if (event.getAllTypes().contains("smartcampus.services.esse3.StudentDataService")
            && DOMAIN_OBJECT_EVENT_TYPE.CUSTOM .equals(event.getEventType())
            && "updateStudentData".equals(event.getEventSubtype())
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
            "smartcampus.services.esse3.StudentDataService",
            DOMAIN_OBJECT_EVENT_TYPE.CUSTOM, 
            "updateStudentData",
            null
            ));        
        return result;
    }
    
}


