load('classpath:scripts/moment.js')
out=JSON.stringify({
    "personalizations": [
        {
            "to": [
                {
                    "email": emailDataProvider,
                    "name": nameDataProvider
                }
            ],
            "dynamic_template_data": {
                "nameDataProvider": nameDataProvider,
                "productSelection": productSelection,
                "coveredPeriod": coveredPeriod,
                "analysisDate": moment(analysisDate).format("DD.MM.YYYY"),
                "comparativeDate": moment(comparativeDate).format("DD.MM.YYYY"),
                "freeText": freeText,
                "dataExtractionFolderShareLink": dataExtractionFolderShareLink
            }
        }
    ],
    "from": {
        "email": "noreply@bananaanalytics.com",
        "name": "Abu the Ape"
    },
    "reply_to": {
        "email": "noreply@bananaanalytics.com",
        "name": "Abu the Ape"
    },
    "template_id": "d-6b8bc5e0db854778a0eed1287639a7f7"
});