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

public class PortfolioDOEngine extends AbstractDOEngineImpl {

    public PortfolioDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "_process_onRelatedCreate_semanticService",
            "_process_onRelatedDelete_semanticService",
            "_destroy",
            "_updateEntity",
            "callEntityUpdate",
            "deletePortfolio",
            "initialize",
            "updatePortfolio",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAEdwQAAAAEc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAN0AAlvcGVyYXRpb250AA9kZWxldGVQb3J0Zm9saW90AAphY3Rpb25OYW1ldAAPZGVsZXRlUG9ydGZvbGlvdAAEdHlwZXQABUxvY2FseHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAABXQACmVuZ2luZVR5cGV0AAhhY3Rpdml0aXEAfgAEdAASZGVsZXRlU2VtYW50aWNEYXRhdAAKcHJvY2Vzc0tleXQAFWRlbGV0ZXBvcnRmb2xpb2VudGl0eXQADXByb2Nlc3NEZWZVUkl0AFRldS90cmVudG9yaXNlL3NtYXJ0Y2FtcHVzL2RvbWFpbi9wb3J0Zm9saW8vYWN0aXZpdGkvZGVsZXRlcG9ydGZvbGlvZW50aXR5LmJwbW4yMC54bWxxAH4ACHQAB1Byb2Nlc3N4c3EAfgACP0AAAAAAAAx3CAAAABAAAAADcQB+AAR0AA91cGRhdGVQb3J0Zm9saW9xAH4ABnQAD3VwZGF0ZVBvcnRmb2xpb3EAfgAIcQB+AAl4c3EAfgACP0AAAAAAAAx3CAAAABAAAAAFcQB+AAt0AAhhY3Rpdml0aXEAfgAEdAASdXBkYXRlU2VtYW50aWNEYXRhcQB+AA50ABV1cGRhdGVwb3J0Zm9saW9lbnRpdHlxAH4AEHQAVGV1L3RyZW50b3Jpc2Uvc21hcnRjYW1wdXMvZG9tYWluL3BvcnRmb2xpby9hY3Rpdml0aS91cGRhdGVwb3J0Zm9saW9lbnRpdHkuYnBtbjIwLnhtbHEAfgAIcQB+ABJ4eA=="));
    }

     public  Collection<java.io.Serializable> getExtensionValues(String property) {
        return extensions.get(property);
     }  
    
    protected Object executeAction(String actionName, DomainObjectWrapper obj, Tuple t, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        if ("_process_onRelatedCreate_semanticService".equals(actionName)) {
            return _process_onRelatedCreate_semanticService(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_process_onRelatedDelete_semanticService".equals(actionName)) {
            return _process_onRelatedDelete_semanticService(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_destroy".equals(actionName)) {
            return _destroy(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_updateEntity".equals(actionName)) {
            return _updateEntity(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("callEntityUpdate".equals(actionName)) {
            return callEntityUpdate(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("deletePortfolio".equals(actionName)) {
            return deletePortfolio(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("initialize".equals(actionName)) {
            return initialize(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("updatePortfolio".equals(actionName)) {
            return updatePortfolio(t, obj, outEvents, ops, securityToken, bundleId);
        }
        return null;
    }

    private Object _destroy(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
getDomainObjectHandler().terminate(obj,evts,bundleId);}
return null;
}

    }
    private Object _updateEntity(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.Long newId = (java.lang.Long) tuple.get("newId");
{
getDomainObjectHandler().setVar("entityId", obj, newId, evts, bundleId);}
return null;
}

    }
    private Object callEntityUpdate(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
if ((getDomainObjectHandler().getVar("entityId",obj,java.lang.Long.class,bundleId) == null) || (getDomainObjectHandler().getVar("entityId",obj,java.lang.Long.class,bundleId)>0)){
{
{
Tuple body = new Tuple();
getDomainObjectHandler().invokeOperation(obj, "updateSemanticData", body, ops, bundleId);}
}
}
}
return null;
}

    }
    private Object deletePortfolio(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
if ((getDomainObjectHandler().getVar("entityId",obj,java.lang.Long.class,bundleId) != null) && (getDomainObjectHandler().getVar("entityId",obj,java.lang.Long.class,bundleId)>0)){
{
{
Tuple body = new Tuple();
getDomainObjectHandler().invokeOperation(obj, "deleteSemanticData", body, ops, bundleId);}
}
}
getDomainObjectHandler().setVar("deleted", obj, true, evts, bundleId);}
return null;
}

    }
    private Object initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
getDomainObjectHandler().setVar("showUserGeneratedData", obj, smartcampus.services.esse3.helper.DomainHelper.getStringArray(), evts, bundleId);getDomainObjectHandler().setVar("highlightUserGeneratedData", obj, smartcampus.services.esse3.helper.DomainHelper.getStringArray(), evts, bundleId);getDomainObjectHandler().setVar("showStudentInfo", obj, smartcampus.services.esse3.helper.DomainHelper.getStringArray(), evts, bundleId);getDomainObjectHandler().setVar("tags", obj, smartcampus.services.esse3.helper.DomainHelper.getTagArray(), evts, bundleId);{
Tuple body = new Tuple();
callEntityUpdate(body, obj, evts, ops, securityToken, bundleId);}
}
return null;
}

    }
    private Object updatePortfolio(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.String newName = (java.lang.String) tuple.get("newName");
java.lang.String[] newShowUserGeneratedData = (java.lang.String[]) tuple.get("newShowUserGeneratedData");
java.lang.String[] newHighlightUserGeneratedData = (java.lang.String[]) tuple.get("newHighlightUserGeneratedData");
java.lang.String[] newShowStudentInfo = (java.lang.String[]) tuple.get("newShowStudentInfo");
eu.trentorise.smartcampus.domain.semantic.Tag[] newTags = (eu.trentorise.smartcampus.domain.semantic.Tag[]) tuple.get("newTags");
{
if (newName != null){
{
getDomainObjectHandler().setVar("name", obj, newName, evts, bundleId);}
}
if (newShowUserGeneratedData != null){
{
getDomainObjectHandler().setVar("showUserGeneratedData", obj, newShowUserGeneratedData, evts, bundleId);}
}
if (newHighlightUserGeneratedData != null){
{
getDomainObjectHandler().setVar("highlightUserGeneratedData", obj, newHighlightUserGeneratedData, evts, bundleId);}
}
if (newShowStudentInfo != null){
{
getDomainObjectHandler().setVar("showStudentInfo", obj, newShowStudentInfo, evts, bundleId);}
}
if (newTags != null){
{
getDomainObjectHandler().setVar("tags", obj, newTags, evts, bundleId);{
Tuple body = new Tuple();
callEntityUpdate(body, obj, evts, ops, securityToken, bundleId);}
}
}
}
return null;
}

    }
    
    private Object _process_onRelatedCreate_semanticService(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper created = (DomainObjectWrapper) tuple.get("created");
       getDomainObjectHandler().addRelatedObject("semanticService", obj, created, evts, bundleId);
       return null;

    }
    private Object _process_onRelatedDelete_semanticService(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper deleted = (DomainObjectWrapper) tuple.get("deleted");
       getDomainObjectHandler().removeRelatedObject("semanticService", obj, deleted, evts, bundleId);
       return null;

    }
    
    
    private List<DomainObjectWrapper> _query_semanticService(DomainObjectWrapper obj, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (true) {
        return getDomainObjectHandler().query("eu.trentorise.smartcampus.domain.semantic.SemanticService", null, securityToken, bundleId);
    }
    return java.util.Collections.emptyList();

    }
    private boolean _matches_semanticService(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        return true;
    }
    
    public void handleObjectRelUpdate(String rName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
            if (false
            ) {
                getDomainObjectHandler().setRelation("semanticService", obj, _query_semanticService(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
    }
    public void handleObjectVarUpdate(String vName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
            if (false
            ) {
                getDomainObjectHandler().setRelation("semanticService", obj, _query_semanticService(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
    }

    public void handleObjectCreate(DomainObjectWrapper obj, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String bundleId) throws DomainDataHandlerException {
            getDomainObjectHandler().setVar("deleted", obj, false, outEvents, bundleId);
            getDomainObjectHandler().setRelation("semanticService", obj, _query_semanticService(obj, obj.getDomainObject().getSecurityToken(), bundleId), outEvents, bundleId);
        __initialize(new Tuple(), obj, outEvents, ops, obj.getDomainObject().getSecurityToken(),bundleId);
    }

    private Object __initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
{
getDomainObjectHandler().setVar("showUserGeneratedData", obj, smartcampus.services.esse3.helper.DomainHelper.getStringArray(), evts, bundleId);getDomainObjectHandler().setVar("highlightUserGeneratedData", obj, smartcampus.services.esse3.helper.DomainHelper.getStringArray(), evts, bundleId);getDomainObjectHandler().setVar("showStudentInfo", obj, smartcampus.services.esse3.helper.DomainHelper.getStringArray(), evts, bundleId);getDomainObjectHandler().setVar("tags", obj, smartcampus.services.esse3.helper.DomainHelper.getTagArray(), evts, bundleId);{
Tuple body = new Tuple();
callEntityUpdate(body, obj, evts, ops, securityToken, bundleId);}
}
return null;
}

    }

    protected ActionInvoke ruleApplies(EvaluableDomainSubscriptionRule rule, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        if ("subscribe_relation_onCreated_semanticService".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (_matches_semanticService(payload, obj, bundleId)){
                Tuple tuple = new Tuple();
                tuple.put("created",payload);
                return new ActionInvoke("_process_onRelatedCreate_semanticService", tuple);
            }
        }
        if ("subscribe_relation_onDeleted_semanticService".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (true){
                Tuple tuple = new Tuple();
                tuple.put("deleted",payload);
                return new ActionInvoke("_process_onRelatedDelete_semanticService", tuple);
            }
        }
        return null;
    }


    @Override
    public boolean isRelation(String key) {
        return false
              || "semanticService".equals(key)
        ;    
    }

    @Override
    public String getType() {
        return "smartcampus.services.esse3.Portfolio";
    }

    @Override
    public boolean isStatic() {
        return !true;
    }

    private static Collection<String> dependencies = new java.util.HashSet<String>();
    static {
        dependencies.add("eu.trentorise.smartcampus.domain.semantic.SemanticService");
        dependencies.add("eu.trentorise.smartcampus.domain.semantic.SemanticService");
        dependencies.add("eu.trentorise.smartcampus.domain.semantic.SemanticService");
    }

    public Collection<String> getDependencies() {
        return dependencies;
    }

    public Collection<DomainSubscriptionRule> getSubscriptions(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> rules = new ArrayList<DomainSubscriptionRule>();
        
        {
            DomainSubscriptionRule 
            rule = new DomainSubscriptionRule();
            rule.setName("subscribe_relation_onCreated_semanticService");
            rule.setSourceId(null);
            rule.setSourceType("eu.trentorise.smartcampus.domain.semantic.SemanticService");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("subscribe_relation_onCreated_semanticService");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CREATED .toString());
            rules.add(rule);
        }
        {
            DomainObjectWrapper ref = obj;
            if (getDomainObjectHandler().getRelationLinks("semanticService", ref, bundleId)!=null) {
                for (DomainRelationTarget target : getDomainObjectHandler().getRelationLinks("semanticService", ref, bundleId)) {
                    DomainSubscriptionRule rule1 = new DomainSubscriptionRule();
                    rule1.setName("subscribe_relation_onDeleted_semanticService " + target.getTargetId());
                    rule1.setSourceId(target.getTargetId());
                    rule1.setSourceType("eu.trentorise.smartcampus.domain.semantic.SemanticService");
                    rule1.setTargetId(obj.getId());
                    rule1.setTargetType(obj.getType());
                    rule1.setEngineName("subscribe_relation_onDeleted_semanticService");
                    rule1.setEventType(DOMAIN_OBJECT_EVENT_TYPE.DELETED .toString());
                    rules.add(rule1);
                }
            }
        }
        return rules;
    }

    
    public it.sayservice.platform.domain.model.interfaces.DomainTypeInterface getInterface() throws it.sayservice.platform.core.domain.common.exception.DomainDataHandlerException {
        return smartcampus.services.esse3 .PortfolioInterface .getInstance();
    }
    

    public List<DomainSubscriptionRule> findSubscriptionRules(DomainEvent event, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> result = new ArrayList<DomainSubscriptionRule>();
        List<DomainSubscriptionRule> tmp = null;
        return result;
    }
    
    public Collection<DomainEventDescriptor> getEventsToQuery() {
        List<DomainEventDescriptor> result = new ArrayList<DomainEventDescriptor>();
        return result;
    }
    
}


