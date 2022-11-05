package com.easyprocess.core.content;

import com.easyprocess.core.entity.ContentEntity;

public interface ContentParser<T> {

  T parse(ContentEntity content);

}
