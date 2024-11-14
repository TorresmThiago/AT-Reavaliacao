INSERT INTO at_user (username, password) values ( 'admin', '$2a$10$df3P/c4RGUCPUozRxjylB.Lj3gRF6PXjDGJETqaqoSex5pIptYhZm');
INSERT INTO at_user (username, password) values ( 'Thiago', '$2a$10$df3P/c4RGUCPUozRxjylB.Lj3gRF6PXjDGJETqaqoSex5pIptYhZm');


INSERT INTO assessment (name, description, user_id, demand, environment, client, start_Date, end_Date, url) values ( 'Aplicativo Itaú', 'Análise de vulnerabilidades do novo site para cliente Itaú, com objetivo de identificar possíveis falhas de segurança.', 2, 0, 0, 'Itaú', '2024-11-10', '2024-12-31', 'http://site-itau.com.br/');
INSERT INTO assessment (name, description, user_id, demand, environment, client, start_Date, end_Date, url) values ( 'Serviço Microsoft', 'Análise de vulnerabilidades do novo site para cliente Microsoft, com objetivo de identificar possíveis falhas de segurança.', 2, 1, 0, 'Microsoft', '2024-10-16', '2024-11-10', 'http://site-ms.com.br/');
INSERT INTO assessment (name, description, user_id, demand, environment, client, start_Date, end_Date, url) values ( 'Sites Google', 'Análise de vulnerabilidades do novo site para cliente Google, com objetivo de identificar possíveis falhas de segurança.', 2, 0, 1, 'Google', '2024-09-26', '2024-10-15', 'http://site-google.com.br/');

INSERT INTO vuln (cwe,affected_item,assessment_id,description,name,owasp_top10,reference,remediation,scorecvss) values (79,'http://site-itau.com.br/home.html', 1,'As aplicação Web está vulnerável ao ataque de cross-site scripting no modo "stored". Cross-site scripting, também conhecido como XSS, é uma vulnerabilidade que possibilita um atacante enviar código malicioso, geralmente na forma de JavaScript, para outro usuário, uma vez que a aplicação não realiza o devido saneamento dos dados recebidos. No caso em questão, foi possível inserir um payload malicioso dentro de alguns casos específicos','Aplicação vulnerável a cross-site scripting', 2,'https://owasp.org/www-community/attacks/xss/','Tratar adequadamente a entrada e saída de dados oriundos do usuário, seja na forma de arquivos, formulários ou outras, codificando os caracteres de acordo com o contexto utilizado (HTML, JavaScript, etc). Recomenda-se também a utilização de bibliotecas especializadas para auxiliar nessa tarefa, como a OWASP ESAPI.', 8.5);
INSERT INTO vuln (cwe,affected_item,assessment_id,description,name,owasp_top10,reference,remediation,scorecvss) values (79,'http://site-itau.com.br/home.html', 1,'As aplicação Web está vulnerável ao ataque de cross-site scripting no modo "stored". Cross-site scripting, também conhecido como XSS, é uma vulnerabilidade que possibilita um atacante enviar código malicioso, geralmente na forma de JavaScript, para outro usuário, uma vez que a aplicação não realiza o devido saneamento dos dados recebidos. No caso em questão, foi possível inserir um payload malicioso dentro de alguns casos específicos','Enumeração de usuários na aplicação', 2,'https://owasp.org/www-community/attacks/xss/','Tratar adequadamente a entrada e saída de dados oriundos do usuário, seja na forma de arquivos, formulários ou outras, codificando os caracteres de acordo com o contexto utilizado (HTML, JavaScript, etc). Recomenda-se também a utilização de bibliotecas especializadas para auxiliar nessa tarefa, como a OWASP ESAPI.', 8.5);
INSERT INTO vuln (cwe,affected_item,assessment_id,description,name,owasp_top10,reference,remediation,scorecvss) values (79,'http://site-itau.com.br/home.html', 1,'As aplicação Web está vulnerável ao ataque de cross-site scripting no modo "stored". Cross-site scripting, também conhecido como XSS, é uma vulnerabilidade que possibilita um atacante enviar código malicioso, geralmente na forma de JavaScript, para outro usuário, uma vez que a aplicação não realiza o devido saneamento dos dados recebidos. No caso em questão, foi possível inserir um payload malicioso dentro de alguns casos específicos','Utilização de senha padrão ou de fácil adivinhação', 2,'https://owasp.org/www-community/attacks/xss/','Tratar adequadamente a entrada e saída de dados oriundos do usuário, seja na forma de arquivos, formulários ou outras, codificando os caracteres de acordo com o contexto utilizado (HTML, JavaScript, etc). Recomenda-se também a utilização de bibliotecas especializadas para auxiliar nessa tarefa, como a OWASP ESAPI.', 8.5);
INSERT INTO vuln (cwe,affected_item,assessment_id,description,name,owasp_top10,reference,remediation,scorecvss) values (79,'http://site-itau.com.br/home.html', 1,'As aplicação Web está vulnerável ao ataque de cross-site scripting no modo "stored". Cross-site scripting, também conhecido como XSS, é uma vulnerabilidade que possibilita um atacante enviar código malicioso, geralmente na forma de JavaScript, para outro usuário, uma vez que a aplicação não realiza o devido saneamento dos dados recebidos. No caso em questão, foi possível inserir um payload malicioso dentro de alguns casos específicos','Uso de bibliotecas com vulnerabilidades conhecidas', 2,'https://owasp.org/www-community/attacks/xss/','Tratar adequadamente a entrada e saída de dados oriundos do usuário, seja na forma de arquivos, formulários ou outras, codificando os caracteres de acordo com o contexto utilizado (HTML, JavaScript, etc). Recomenda-se também a utilização de bibliotecas especializadas para auxiliar nessa tarefa, como a OWASP ESAPI.', 8.5);