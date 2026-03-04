# GoogleDriveApi

## 📌 Описание

Проект на Java для работы с Google Drive API — демонстрация загрузки и работы с файлами в облачном хранилище Google Drive через API.  
Проект использует официальную библиотеку Google API для Java.

---

## 🛠️ Технологии

- Java  
- Google Drive API  
- Maven  
- Git  
- REST API  

---

## 🚀 Функциональность

Приложение выполняет базовые операции с Google Drive через API:  
✔ Авторизация через OAuth  
✔ Загрузка файлов  
✔ Получение информации о файлах  

---

## 📥 Требования

1. Java 11 или выше  
2. Maven  
3. Google Cloud проект с включенным Google Drive API  
4. Файл `credentials.json` с OAuth-клиентом (скачивается в Google Cloud Console) :contentReference[oaicite:1]{index=1}

---

## 🚀 Как запустить

1. Создай проект в Google Cloud Console и **включи Google Drive API**. :contentReference[oaicite:2]{index=2}  
2. Скачай `credentials.json` и помести его в папку `src/main/resources/`  
3. Собери проект:

   ```bash
   mvn clean install
