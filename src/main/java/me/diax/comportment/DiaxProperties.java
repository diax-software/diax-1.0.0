/*
 * Copyright 2017 Comportment | comportment@diax.me
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.diax.comportment;

import com.knockturnmc.api.util.NamedProperties;
import com.knockturnmc.api.util.Property;

/**
 * Created by Comportment at 21:18 on 15/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class DiaxProperties extends NamedProperties {

    @Property("token")
    private String token;

    @Property("prefix")
    private String prefix;

    @Property("game")
    private String game;

    public String getToken() {
        return token;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getGame() {
        return game;
    }
}