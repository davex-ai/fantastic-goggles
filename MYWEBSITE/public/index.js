const express = require('express');
const path = require('path');
const nodemailer = require('nodemailer');

const app = express();
const port = 3000;

// Middleware to serve static files and parse form data , Serve static files (HTML, CSS)
app.use(express.static('public'));
app.use(express.urlencoded({ extended: true }));

// Home route
app.get('/', (req, res) => res.sendFile(path.join(__dirname, 'index.html')));

// Contact route
app.get('/contact', (req, res) => res.sendFile(path.join(__dirname, 'contact.html')));

// Form submission route
app.post('/submit', (req, res) => {
    const { name, email, message } = req.body;

    console.log(`Name: ${name}, Email: ${email}, Message: ${message}`);

    // Set up Nodemailer transporter
    const transporter = nodemailer.createTransport({
        service: 'gmail', 
        auth: {
            user: 'your_email@gmail.com',
            pass: 'your_password'
        }
    });
    
    function toggleMenu() {
        document.querySelector('.menu').classList.toggle('active');
    }
    

    // Email content
    const mailOptions = {
        from: email,
        to: 'your_email@gmail.com',
        subject: `New message from ${name}`,
        text: `You got a new message from:
        Name: ${name}
        Email: ${email}
        Message: ${message}`
    };

    // Send the email
    transporter.sendMail(mailOptions, (error, info) => {
        if (error) {
            console.log('Error:', error);
            res.send('<h1>Oops! Something went wrong. Try again later.</h1>');
        } else {
            console.log('Email sent: ' + info.response);
            res.send(`<h1>Thanks, ${name}! Your message has been sent.</h1>
                      <a href="/contact">Back to Contact</a>`);
        }
    });
});

// Start the server
app.listen(port, () => console.log(`Server running at http://localhost:${port}`));
