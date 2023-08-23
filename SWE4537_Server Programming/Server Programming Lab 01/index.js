// const express = require('express')
// const app = express()
// const port = 3000

// app.get('/', (req, res) => {
//   res.send('Hello World!, Hello Earth!!')
// })

// app.listen(port, () => {
//   console.log(`Example app listening on port ${port}`)
// })


// const express = require('express');
// const app = express();
// const port = 3000;


// app.get('/', (req, res) => {
//   res.send('Hello World, Hello Earth!');
// });


// app.get('/about', (req, res) => {
//   res.send('This is the About Earth.');
// });


// app.get('/contact', (req, res) => {
//   res.send('You can contact Mars!!!');
// });


// app.listen(port, () => {
//   console.log(`Example app listening on port ${port}`);
// });



const express = require('express');
const path = require('path'); 
const app = express();
const port = 3000;


const htmlFilePath = path.join(__dirname, 'index.html');

// app.get('/', (req, res) => {
//   res.send('Hello World, Hello Earth!');
// });


app.get('/about', (req, res) => {
  res.send('This is the About Earth.');
});


app.get('/contact', (req, res) => {
  res.send('You can contact Mars!!!');
});


app.get('/', (req, res) => {

  res.sendFile(htmlFilePath);
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
