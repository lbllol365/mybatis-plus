/*
 * Copyright (c) 2011-2020, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.plugins.parser;

import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.update.Update;

/**
 * 攻击 SQL 阻断解析器
 *
 * @author hubin
 * @since 2018-07-17
 */
public class BlockAttackSqlParser extends AbstractJsqlParser {

    @Override
    public void processInsert(Insert insert) {
        // to do nothing
    }

    @Override
    public void processDelete(Delete delete) {
        if (null != delete.getWhere()) {
            throw new MybatisPlusException("Prohibition of full table deletion");
        }
    }

    @Override
    public void processUpdate(Update update) {
        if (null != update.getWhere()) {
            throw new MybatisPlusException("Prohibition of table update operation");
        }
    }

    @Override
    public void processSelectBody(SelectBody selectBody) {
        // to do nothing
    }
}