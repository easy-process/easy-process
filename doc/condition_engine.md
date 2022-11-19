# 条件引擎

## 技术说明

使用 `google aviator` 作为求值引擎, 结合 `spring context`

## 需求列表

1. 发起人/表单联系人 ` 属于/不属于 ` 部门/人员列表/角色

> starterBelong(actual, operands)

2. 表单单选 ` 属于/不属于 ` 选项列表

> singleSelectBelong(actual, operands)

3. 表单多选 ` 包含/不包含 ` 多选列表

> multipleSelectContains(actual, operands)

4. 表单多选 ` 交集/无交集 ` 多选列表 ?

> multipleSelectAnyMatch(actual, operands)

5. 表单多选 ` 等于/不等于 ` 多选列表

> multipleSelectEquals(actual, operands)

6. 表单部门 ` 属于/不属于 ` 部门列表

> deptBelong(actual, operands)

7. 数字 `大于, 小于, 等于 ...` 实际值

> gt(actual, operands)
> ge(actual, operands)
> lt(actual, operands)
> le(actual, operands)
> eq(actual, operands)
> ne(actual, operands)

## 属性说明 & 定义

## 固定参数名

| 属性名 | 编码 |
| --- | --- |
| 发起人 | __STARTER |
