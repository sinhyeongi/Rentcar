package Mapping;

public class ViewResolver {
	public static String getPageName(String page) {
		return "WEB-INF/View/"+page+".jsp";
	}
}
