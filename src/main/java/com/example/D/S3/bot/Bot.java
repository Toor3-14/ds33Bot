package com.example.D.S3.bot;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "DetskiySad33Bot";


    }

    @Override
    public String getBotToken() {
        return "5274817954:AAGfp10JwfoJUEn9_MmSe5e3V-hNalmDuGE";
    }

    @Override
    public void onUpdateReceived(Update update) {


        if (update.hasMessage() && update.getMessage().hasText()) {
            if (update.getMessage().getText().equalsIgnoreCase("/Бот")) {

                String firstName = update.getMessage().getFrom().getFirstName();
                SendMessage message = new SendMessage();
                message.setChatId(update.getMessage().getChatId().toString());
                message.setText("Привет, " + firstName + "! Я помощник Алисы Александровны, чем Вам помочь?");
                message.enableMarkdown(true);

                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
                InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
                //InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
                InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
                InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();
                InlineKeyboardButton inlineKeyboardButton8 = new InlineKeyboardButton();
                InlineKeyboardButton inlineKeyboardButton9 = new InlineKeyboardButton();
                InlineKeyboardButton inlineKeyboardButton10 = new InlineKeyboardButton();


                inlineKeyboardButton1.setText("В какое время тихий час");
                inlineKeyboardButton1.setCallbackData("С 13:00 до 15:15");
                inlineKeyboardButton2.setText("Телефон сада");
                inlineKeyboardButton2.setCallbackData("+7-967-358-59-49");
                inlineKeyboardButton3.setText("Наш сайт");
                inlineKeyboardButton3.setCallbackData("http://дс33.рф");
                inlineKeyboardButton4.setText("Вконтакте");
                inlineKeyboardButton4.setCallbackData("https://vk.com/detskiy_sad_33");
                //inlineKeyboardButton5.setText("Страница в Инстаграм");
                //inlineKeyboardButton5.setCallbackData("https://instagram.com/detskiysad_33");
                inlineKeyboardButton6.setText("Канал в телеграм");
                inlineKeyboardButton6.setCallbackData("https://t.me/ds33spb");
                inlineKeyboardButton7.setText("Часы работы ответств. за доп. услуги");
                inlineKeyboardButton7.setCallbackData("Среда 13:00-18:00");
                inlineKeyboardButton8.setText("Время работы мед. кабинета");
                inlineKeyboardButton8.setCallbackData("С 9:00 до 16:00 (обед 12:00-13:00)");


                inlineKeyboardButton9.setText("Платные услуги");
//                SendPhoto sendPhoto = new SendPhoto();
//                InputFile inputFile = new InputFile();
//                inputFile.setMedia();
//                sendPhoto.setPhoto();


                inlineKeyboardButton9.setCallbackData("red");

                inlineKeyboardButton10.setText("Расписание");
                inlineKeyboardButton10.setCallbackData("Расписание");


                // inlineKeyboardButton9.setCallbackData();

                List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
                List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
                List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
                List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();
                //List<InlineKeyboardButton> keyboardButtonsRow5 = new ArrayList<>();
                List<InlineKeyboardButton> keyboardButtonsRow6 = new ArrayList<>();
                List<InlineKeyboardButton> keyboardButtonsRow7 = new ArrayList<>();
                List<InlineKeyboardButton> keyboardButtonsRow8 = new ArrayList<>();
                List<InlineKeyboardButton> keyboardButtonsRow9 = new ArrayList<>();
                List<InlineKeyboardButton> keyboardButtonsRow10 = new ArrayList<>();

                keyboardButtonsRow1.add(inlineKeyboardButton1);
                keyboardButtonsRow2.add(inlineKeyboardButton2);
                keyboardButtonsRow3.add(inlineKeyboardButton3);
                keyboardButtonsRow4.add(inlineKeyboardButton4);
                //keyboardButtonsRow5.add(inlineKeyboardButton5);
                keyboardButtonsRow6.add(inlineKeyboardButton6);
                keyboardButtonsRow7.add(inlineKeyboardButton7);
                keyboardButtonsRow8.add(inlineKeyboardButton8);
                keyboardButtonsRow9.add(inlineKeyboardButton9);
                keyboardButtonsRow10.add(inlineKeyboardButton10);
                List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
                rowList.add(keyboardButtonsRow1);
                rowList.add(keyboardButtonsRow2);
                rowList.add(keyboardButtonsRow3);
                rowList.add(keyboardButtonsRow4);
                //rowList.add(keyboardButtonsRow5);
                rowList.add(keyboardButtonsRow6);
                rowList.add(keyboardButtonsRow7);
                rowList.add(keyboardButtonsRow8);
                rowList.add(keyboardButtonsRow9);
                rowList.add(keyboardButtonsRow10);
                inlineKeyboardMarkup.setKeyboard(rowList);

                message.setReplyMarkup(inlineKeyboardMarkup);
//769454107
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } else if (update.hasCallbackQuery()) {
            try {
                String data = update.getCallbackQuery().getData();
                if (data.equals("Расписание")) {
                    SendPhoto sendPhoto = new SendPhoto();
                    InputFile inputFile = new InputFile();
//                    File file = new File("https://sun9-12.userapi.com/impf/c844520/v844520066/ae434/UA4NvgCqwkY.jpg?size=810x1080&quality=96&sign=418d84e67e1e6b1e77cabc88f8bce9dd&type=album");
//
//                    inputFile.setMedia(file);
                    inputFile.setMedia("https://disk.yandex.ru/i/6QEum3IpXkrvDA");
                    sendPhoto.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
                    sendPhoto.setPhoto(inputFile);
                    sendPhoto.setCaption(data);
                    execute(sendPhoto);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add("1.Английский язык");
                    list.add("2.Вокальный кружок");
                    list.add("3.Раз-словечко, два-словечко");
                    list.add("4.Танцевально-ритмическая гимнастика");
                    list.add("5.Школа мяча");
                    list.add("6.Волшебная кисточка");
                    list.add("http://дс33.рф/sveden/paid_edu/");
                    SendMessage sendMessage = new SendMessage();

                    sendMessage.setText(data);
                    if (sendMessage.getText().equals("red")) {
                        sendMessage.setText(String.join("\n", list));
                    }
                    sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
                    execute(sendMessage);
                }


            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }


    }


}



