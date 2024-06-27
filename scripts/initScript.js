db = db.getSiblingDB('dmenu-db')
db.createCollection('test_collection')

var jsonDocuments = [
    {
        "_id": "456",
        "value": "privet",
        "_class": "test_entity"
    },
];

jsonDocuments.forEach(function (document) {
    db.test_collection.insert(document);
});