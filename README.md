Starting application
------------------

Tools
----------

The tools that you'll need for developping on this project are :

* **Git** : https://git-scm.com/
* **Jdk 17** (we won't be doing JEE)
* **Node.js** (requires version is 18.16.1 or higher) : https://nodejs.org/en/
* Choose one package manager among :
    * **Yarn** (use the latest version of Yarn) : https://yarnpkg.com/en/
    * **Npm** (any version of npm that is greater than or equal to 9.5.1) : https://www.npmjs.com/
* **Maven** : https://maven.apache.org/
* Your favorite IDE. If you don't have any idea :
    * **Intellij** : https://www.jetbrains.com/idea/
    * **Eclipse** : https://www.eclipse.org/downloads/eclipse-packages/ (latest version is recommended)
        * *Recommended plugins* :
            * For correct handling of SpringBoot apps : **Spring Tool Suite** : http://marketplace.eclipse.org/content/spring-tool-suite-sts-eclipse
            * For easier project browsing outside the IDE : **EasyShell** : http://marketplace.eclipse.org/content/easyshell
            * For coverage analysis : **EclEmma** : http://marketplace.eclipse.org/content/eclemma-java-code-coverage
            * For (partial) .editorconfig integration : **editorconfig-eclipse** : http://marketplace.eclipse.org/content/editorconfig-eclipse
            * (*beware, NOT RECOMMENDED over VSCode, only try it if you dare experience an unfinished Eclipse plugin*) For Angular2 integration : **Angular2 Eclipse** : http://marketplace.eclipse.org/content/angular2-eclipse
    * You also need to install **Lombok** on your IDE (by double-clicking on Lombok Maven JAR dependency).
    * **VSCode** : https://code.visualstudio.com/
        * *Recommended plugins* :
            * Prettier - Code formatter : **Code Formatter** : https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode
            * Beautify - HTML formatter : **HTML Formatter** : https://marketplace.visualstudio.com/items?itemName=HookyQR.beautify
            * Eclipse keyboard shortcuts : **Eclipse Keymap** : https://marketplace.visualstudio.com/items?itemName=alphabotsec.vscode-eclipse-keybindings
            * See issues in your TypeScript code : **TSLint** : https://marketplace.visualstudio.com/items?itemName=ms-vscode.vscode-typescript-tslint-plugin
            * NgBootstrap Snippets for VS Code : **NgBootstrap Snippets** : https://marketplace.visualstudio.com/items?itemName=ktriek.ng-bootstrap-snippets
            * Icon Pack for VS Code : **vscode-icons** : https://marketplace.visualstudio.com/items?itemName=robertohuertasm.vscode-icons
    * **Atom** : https://atom.io/

* An instance of **Microsoft SQL Server** or for more convenience **docker** : https://www.docker.com/

* A browser, we highly recommend using Google Chrome.

* activate (format and remove useless imports) on save in your IDE.

## Starting Database service
1. Mount the DOCKER image :

`docker run -dit -e 'ACCEPT_EULA=Y' -e 'MSSQL_SA_PASSWORD=$mySecretPassw0rd$' --name 'msqls' -p 1433:1433 -d mcr.microsoft.com/mssql/server`

2. Wait for the msqls image to finish booting :

`docker logs msqls`

3. Start an interactive shell session inside the msqls container :

`docker exec -it msqls bash`

4. Connect to our Microsoft SQL Server instance :

`/opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P '$mySecretPassw0rd$'`

5. Once connected, create the database using the following SQL command :

`CREATE DATABASE Softway` Then type `GO` in the next prompt hit enter to run your SQL query

## Starting softway API service:

To start softway API service, you can start it from your IDE, by running the MAIN SpringBoot class.

Or you can go to softway-back folder and run `mvn spring-boot:run` in a terminal.

## Starting softway front APP:

To start softway front APP, go to softway-front folder, open a terminal and install required packages by runnnig : `npm install` or `yarn install`.

once packages are installed, you can start the local DEV server with the command `npm start` or `yarn start`.

**NB** : it's important that you use one of these commands, to make sure you are using the proxy configuration when launching the dev server.

once all done. you can access application on `localhost:4200`.
