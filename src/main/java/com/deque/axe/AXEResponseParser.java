package com.deque.axe;

import org.json.JSONArray;
import org.json.JSONObject;

public class AXEResponseParser {
  private static final String lineSeparator = System.getProperty("line.separator");

  public static StringBuilder responseParser(JSONObject responseJSON) {
    final StringBuilder sb = new StringBuilder();
    JSONObject failures;
    JSONArray violations;
    JSONArray impact;
    JSONObject node;
    JSONArray errors = responseJSON.getJSONArray("passes");
    sb.append("===========================Major Violations================================").append(lineSeparator);
    if (responseJSON.getJSONArray("violations").length() != 0) {
      sb.append(
          "Important violations are:---> " + AXE.report(responseJSON.getJSONArray("violations")));
    } else {
      sb.append("Important violations are:---> None");
    }
    for (int i = 0; i < errors.length(); i++) {
      sb.append(lineSeparator);
      failures = errors.getJSONObject(i);
      violations = failures.getJSONArray("nodes");
      sb.append("===========================Other Vi0olations================================")
          .append(lineSeparator).append("Violation is: -->" + failures.get("help"))
          .append(lineSeparator)
          .append("Description of the violation --> " + failures.get("description"))
          .append(lineSeparator).append("Help URL: -->" + failures.get("helpUrl"))
          .append(lineSeparator);
      for (int j = 0; j < violations.length(); j++) {
        node = violations.getJSONObject(j);
        sb.append("Elements violated are: ---> " + node.get("html")).append(lineSeparator);
        sb.append("Target violated are: ---> " + node.get("target")).append(lineSeparator);
        impact = node.getJSONArray("any");
        // System.out.println(impact.get("impact").toString());
        // impact=node.getJSONObject("any");
        try {
          sb.append("impact of this violation is:-->" + impact.getJSONObject(0).get("impact"))
              .append(lineSeparator);
          sb.append("Additional Data is -->" + impact.getJSONObject(0).get("data").toString())
              .append(lineSeparator);
        } catch (Exception e) {
          // gulp the exception
        }
      }
    }
    return sb;
  }
}
