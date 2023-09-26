const LocalStrategy = require('passport-local').Strategy
const bcrypt = require('bcrypt')
const path = require('path');

const fs = require('fs');   

function initialize(passport) {

  const usersFilePath = path.join(__dirname, '..', 'data', 'user-data.json');
  const users = JSON.parse(fs.readFileSync(usersFilePath , 'utf-8'));

  const authenticateUser = async (email, password, done) => {
    const user = users.find((user) => user.email === email);
    if (user == null) {
      return done(null, false, { message: 'No user with that email' })
    }

    try {
      if (await bcrypt.compare(password, user.password)) {
        return done(null, user)
      } else {
        console.log("email")
        return done(null, false, { message: 'Password incorrect' })
      }
    } catch (e) {
      return done(e)
    } 
  }

  passport.use(new LocalStrategy({ usernameField: 'email' }, authenticateUser)) 

  passport.serializeUser((user, done) => {
    done(null, user.id);      
  });

  passport.deserializeUser((id, done) => {
    const user = users.find((user) => user.id === id);
    done(null, user);   
  });

}

module.exports = initialize