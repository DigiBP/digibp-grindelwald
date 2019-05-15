load('classpath:scripts/moment.js')
out=JSON.stringify({
        "personalizations": [
          {
            "to": [
                {
                "email" : "hiwoca@mail-finder.net",
                "name" : "TT"
              }
            ],
            "dynamic_template_data": {
              "name": "TT"
            }
          }
        ],
        "from": {
          "email": "noreply@johndoe.com",
          "name": "John Doe"
        },
        "reply_to": {
          "email": "noreply@johndoe.com",
          "name": "John Doe"
        },
        "template_id": "d-ca56e522541240059bc97b6d8ca41f9c"
});