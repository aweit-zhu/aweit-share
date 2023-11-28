package com.example.tags;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class LayoutTag extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		try {
            pageContext.include("/WEB-INF/view/header.jsp");
        } catch (IOException | ServletException e) {
            throw new JspException(e);
        }
        return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
        try {
            pageContext.include("/WEB-INF/view/footer.jsp");
        } catch (IOException | ServletException e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
	}

}
