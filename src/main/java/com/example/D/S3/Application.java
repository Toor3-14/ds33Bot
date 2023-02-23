package com.example.D.S3;

import com.example.D.S3.bot.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.ApiConstants;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;




@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(new Bot());
			SpringApplication.run(Application.class, args);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

}
