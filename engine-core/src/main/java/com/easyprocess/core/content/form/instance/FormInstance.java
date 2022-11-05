package com.easyprocess.core.content.form.instance;

import java.util.List;

import com.easyprocess.core.org.User;

public interface FormInstance {

  List<User> getFormContact(String formItemId);

}
