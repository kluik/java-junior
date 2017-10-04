package com.acme.edu;

/**
 * Класс LoggerController выполняет функцию контроллера, его задача сводится к функции setMessage - к проверке:
 *  Если сообщение появилось первый раз и до него не было никаких сообщений, тогда мы запускаем фильтрацию сообщения самому от себя
 *  Если пришедшее сообщение не перове, тогда мы подаем на фильтр предыдущего сообщения наге текущее сообщение
 * Далее просто переставляем ссылку с предыдущего сообщения на текущее.
 *  Функция flushBuffer предназначена для сброса буфера при смене типа, при вызове функции close и т.д.
 */
public class LoggerController {
    private MetaMessage message;

    public void setMessage(MetaMessage message) {
        if(this.message == null && message != null) {
            message.filter(message);
        }
        if (message != null && this.message != null) {
            this.message.filter(message);
        }
        this.message = message;
    }

    public void flushBuffer () {
        this.message.flushBuffer();
    }
}
