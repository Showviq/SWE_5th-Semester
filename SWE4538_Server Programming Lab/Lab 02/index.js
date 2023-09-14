const os = require("os");
console.log(os.userInfo());
const currentOS =
{
name:
    os.type(),
release:
    os.release(),
totalMem:
    os.totalmem(),
freeMem:
    os.freemem()
}
console.log(currentOS);
const fs = require("fs");
console.log("Before.. ");
fs.writeFileSync("200042156.txt", "Goodbye");

fs.readFile("./200042156.txt", "utf-8", (err, data) =>
{
    if (err)
    {
        console.log(err);
    }
    else
    {
        console.log(data);
        fs.appendFile(
            "200042156.txt",
            " World",
            (err) =>
        {
            if (err)
            {
                console.log(err);
            }
            else
            {
                
                console.log("After.. ");
                fs.readFile("200042156.txt", "utf-8", (err, data) =>
                {
                    if (err)
                    {
                        console.log(err);
                    }
                    else
                    {
                        console.log(data);
                    }
                    console.log("The text isn't appended, xD!!"); 
                });
                
            }
        });

    }
});


// fs.writeFile(
//     "./200042156.txt",
//     " Yesterday is history,tomorrow is a mystery, and today is a gift... that's why they call it present \n",
//     (error) =>
// {
//     if (error)
//     {
//         console.log(error);
//     }
//     else
//     {
//         console.log("Successful!!");
//     }
// });
