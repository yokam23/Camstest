package com.concerto.common.reports;

import java.util.HashMap;
import java.util.List;

public class ConsolidatedReportBuilder {
	
	public static String HTML_Header_Builder(List<HashMap<String,String>> Map1,String Summary) {
		
		StringBuilder htmlBuilder = new StringBuilder();
		htmlBuilder.append("<html>");
		htmlBuilder.append("<head>");
		htmlBuilder.append("<style>");
		htmlBuilder.append("table, th, td {\r\n" + 
				"  border: 1px solid black;\r\n" + 
				"  border-collapse: collapse;\r\n" + 
				"}");
		htmlBuilder.append("th, td {\r\n" + 
				"  padding: 5px;\r\n" + 
				"  text-align: left;\r\n" + 
				"}");
		htmlBuilder.append("</style>");
		htmlBuilder.append("</head>");
		htmlBuilder.append("<body>");
		
		htmlBuilder.append("<h2>Test Summary Report</h2>");
		htmlBuilder.append(Summary);
		
		htmlBuilder.append("<h2>Summary Of Errors/Failures</h2>");
		
		htmlBuilder.append(htmlTableBuilder_Final((Map1)));
		
		htmlBuilder.append("</body>");
		htmlBuilder.append("</html>");
		String html = htmlBuilder.toString();
		return html;
	}
	
	public static String htmlTableBuilder_Final(List<HashMap<String,String>> Map1) {
		StringBuilder htmlBuilder = new StringBuilder();
		
		
		htmlBuilder.append("<table>");
		
		htmlBuilder.append(String.format("<tr><th>%s</th><th>%s</th><th>%s</th><th>%s</th><th>%s</th></tr>",
	            "SlNo", "TC","Type","Errors","Page"));
		for(int i=0;i<Map1.size();i++) {
			htmlBuilder.append("</tr>");
				htmlBuilder.append(String.format("<td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td>",
						Integer.toString(i),Map1.get(i).get("TCName"),Map1.get(i).get("Type"),Map1.get(i).get("TCError"),"NA"
						));
			htmlBuilder.append("</tr>");
		}

		htmlBuilder.append("</table>");

		String html = htmlBuilder.toString();
		return html;
	}
	
	public static String htmlSummaryTable_Final(int Total, int passed, int failed, int skipped) {
		StringBuilder htmlBuilder = new StringBuilder();
		
		
		htmlBuilder.append("<table>");
		
		
		htmlBuilder.append(String.format("<tr><th>%s</th><th>%s</th><th>%s</th><th>%s</th></tr>",
	            "Total Tests", "Passed Tests","Failed Tests","Skipped Tests"));
		htmlBuilder.append(String.format("<tr><td>%d</td><td>%d</td><td>%d</td><td>%d</td></tr>",
				Total, passed,failed,skipped));


		htmlBuilder.append("</table>");

		String html = htmlBuilder.toString();
		return html;
	}

}
