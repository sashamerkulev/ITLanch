
# Multi module single activity concept project

- Core - Java module contains declarations such as interfaces and data classes (no dependencies)
- Commons - Android module contains Android framework dependent common declaration (depends on Core)
- Domain - Java module contains implementation of business logic independent from Android framework and it contains packages according to features (depends on Core)
- Data - Android module contains network, database and shared preference dependencies (no dependencies)
- Repository - Android module facades Data Android module from Domain module and it also contains packages according to features (depends on Core, Data)
- Login, Order, Halls - Android module contains feature specific code such as view, presenter and etc (depends on Core, Commons)
- Injector - Android module creates feature classes such as presenters, interactors and repository according to features and it also contains packages according to features (depends on Core, Commons, Data, Repository, DoOmain, Login, Halls, Order)

License
-------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
