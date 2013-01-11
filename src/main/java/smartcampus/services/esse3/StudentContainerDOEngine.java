/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
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

public class StudentContainerDOEngine extends AbstractDOEngineImpl {

    public StudentContainerDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "_process_onRelatedDelete_presentation",
            "_process_onRelatedDelete_skills",
            "updatePresentation",
            "updateSkills",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAACdwQAAAACc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAN0AAlvcGVyYXRpb250ABJ1cGRhdGVQcmVzZW50YXRpb250AAphY3Rpb25OYW1ldAASdXBkYXRlUHJlc2VudGF0aW9udAAEdHlwZXQABUxvY2FseHNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAA3EAfgAEdAAMdXBkYXRlU2tpbGxzcQB+AAZ0AAx1cGRhdGVTa2lsbHNxAH4ACHEAfgAJeHg="));
    }

     public  Collection<java.io.Serializable> getExtensionValues(String property) {
        return extensions.get(property);
     }  
    
    protected Object executeAction(String actionName, DomainObjectWrapper obj, Tuple t, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        if ("_process_onRelatedDelete_presentation".equals(actionName)) {
            return _process_onRelatedDelete_presentation(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_process_onRelatedDelete_skills".equals(actionName)) {
            return _process_onRelatedDelete_skills(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("updatePresentation".equals(actionName)) {
            return updatePresentation(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("updateSkills".equals(actionName)) {
            return updateSkills(t, obj, outEvents, ops, securityToken, bundleId);
        }
        return null;
    }

    private Object updatePresentation(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
DomainObjectWrapper newPresentation = (DomainObjectWrapper) tuple.get("newPresentation");
{
getDomainObjectHandler().setRelation("presentation", obj, newPresentation, evts, bundleId);}
return null;
}

    }
    private Object updateSkills(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
List<DomainObjectWrapper> newSkills = (List<DomainObjectWrapper>) tuple.get("newSkills");
{
getDomainObjectHandler().setRelation("skills", obj, newSkills, evts, bundleId);}
return null;
}

    }
    
    private Object _process_onRelatedDelete_presentation(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper deleted = (DomainObjectWrapper) tuple.get("deleted");
       getDomainObjectHandler().removeRelatedObject("presentation", obj, deleted, evts, bundleId);
       return null;

    }
    private Object _process_onRelatedDelete_skills(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper deleted = (DomainObjectWrapper) tuple.get("deleted");
       getDomainObjectHandler().removeRelatedObject("skills", obj, deleted, evts, bundleId);
       return null;

    }
    
    
    
    public void handleObjectRelUpdate(String rName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
    }
    public void handleObjectVarUpdate(String vName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
    }

    public void handleObjectCreate(DomainObjectWrapper obj, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String bundleId) throws DomainDataHandlerException {
        __initialize(new Tuple(), obj, outEvents, ops, obj.getDomainObject().getSecurityToken(),bundleId);
    }

    private Object __initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        return null;
    }

    protected ActionInvoke ruleApplies(EvaluableDomainSubscriptionRule rule, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        if ("subscribe_relation_onDeleted_presentation".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (true){
                Tuple tuple = new Tuple();
                tuple.put("deleted",payload);
                return new ActionInvoke("_process_onRelatedDelete_presentation", tuple);
            }
        }
        if ("subscribe_relation_onDeleted_skills".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (true){
                Tuple tuple = new Tuple();
                tuple.put("deleted",payload);
                return new ActionInvoke("_process_onRelatedDelete_skills", tuple);
            }
        }
        return null;
    }


    @Override
    public boolean isRelation(String key) {
        return false
              || "presentation".equals(key)
              || "skills".equals(key)
        ;    
    }

    @Override
    public String getType() {
        return "smartcampus.services.esse3.StudentContainer";
    }

    @Override
    public boolean isStatic() {
        return !true;
    }

    private static Collection<String> dependencies = new java.util.HashSet<String>();
    static {
        dependencies.add("smartcampus.services.esse3.UserProducedData");
        dependencies.add("smartcampus.services.esse3.UserProducedData");
        dependencies.add("smartcampus.services.esse3.UserProducedData");
        dependencies.add("smartcampus.services.esse3.UserProducedData");
    }

    public Collection<String> getDependencies() {
        return dependencies;
    }

    public Collection<DomainSubscriptionRule> getSubscriptions(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> rules = new ArrayList<DomainSubscriptionRule>();
        
        {
            DomainObjectWrapper ref = obj;
            if (getDomainObjectHandler().getRelationLinks("presentation", ref, bundleId)!=null) {
                for (DomainRelationTarget target : getDomainObjectHandler().getRelationLinks("presentation", ref, bundleId)) {
                    DomainSubscriptionRule rule1 = new DomainSubscriptionRule();
                    rule1.setName("subscribe_relation_onDeleted_presentation " + target.getTargetId());
                    rule1.setSourceId(target.getTargetId());
                    rule1.setSourceType("smartcampus.services.esse3.UserProducedData");
                    rule1.setTargetId(obj.getId());
                    rule1.setTargetType(obj.getType());
                    rule1.setEngineName("subscribe_relation_onDeleted_presentation");
                    rule1.setEventType(DOMAIN_OBJECT_EVENT_TYPE.DELETED .toString());
                    rules.add(rule1);
                }
            }
        }
        {
            DomainObjectWrapper ref = obj;
            if (getDomainObjectHandler().getRelationLinks("skills", ref, bundleId)!=null) {
                for (DomainRelationTarget target : getDomainObjectHandler().getRelationLinks("skills", ref, bundleId)) {
                    DomainSubscriptionRule rule1 = new DomainSubscriptionRule();
                    rule1.setName("subscribe_relation_onDeleted_skills " + target.getTargetId());
                    rule1.setSourceId(target.getTargetId());
                    rule1.setSourceType("smartcampus.services.esse3.UserProducedData");
                    rule1.setTargetId(obj.getId());
                    rule1.setTargetType(obj.getType());
                    rule1.setEngineName("subscribe_relation_onDeleted_skills");
                    rule1.setEventType(DOMAIN_OBJECT_EVENT_TYPE.DELETED .toString());
                    rules.add(rule1);
                }
            }
        }
        return rules;
    }

    
    public it.sayservice.platform.domain.model.interfaces.DomainTypeInterface getInterface() throws it.sayservice.platform.core.domain.common.exception.DomainDataHandlerException {
        return smartcampus.services.esse3 .StudentContainerInterface .getInstance();
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


