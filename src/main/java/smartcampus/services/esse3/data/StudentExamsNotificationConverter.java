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
package smartcampus.services.esse3.data;

import it.sayservice.platform.core.domain.actions.DataConverter;
import it.sayservice.platform.core.domain.ext.Tuple;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import smartcampus.service.esse3.data.message.Esse3.Exam;
import smartcampus.service.esse3.data.message.Esse3.Student;
import smartcampus.service.esse3.data.message.Esse3.StudentExams;

import com.google.protobuf.ByteString;

public class StudentExamsNotificationConverter implements DataConverter {

	@Override
	public Serializable toMessage(Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object fromMessage(Serializable object) {
		List<ByteString> data = (List<ByteString>)object;
		for (ByteString bs : data) {
			try {
//				Exam e = Exam.parseFrom(bs);
//				ExamData ed = new ExamData(e);
//				list.add(ed);
				StudentExams ex = StudentExams.parseFrom(bs);
				
				List<ExamData> list = new ArrayList<ExamData>();
				for (Exam e: ex.getExamsList()) {
				ExamData ed = new ExamData(e);
				list.add(ed);					
				}
				
				Map<String, Object> map = new TreeMap<String, Object>();
				map.put("data", list.toArray(new ExamData[list.size()]));
				map.put("serviceIdAda", ex.getIdAda());

				return map;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}	
	
	

}
