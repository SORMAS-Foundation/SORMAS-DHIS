<%-- 
    Document   : analytics_staging.jsp
    Created on : May 9, 2020, 12:32:56 PM
    Author     : Mathew Official
--%>

<%@page import="com.mirabilia.org.hzi.Util.analysisDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Please wait...</title>
        <style>

            @import url(https://fonts.googleapis.com/css?family=Anonymous+Pro);


            #dvi1{
                height: 100vh;
                margin: 0;

                justify-content: center;
                align-items: center;
                color: rgba(255,255,255,.75);
                font-family: 'Anonymous Pro', monospace; 
            }

            body{
                height: 100vh;
                margin: 0;
                display: flex;
                justify-content: center;
                color: rgba(255,255,255,.75);
                font-family: 'Anonymous Pro', monospace;  
                background-color: #191f26;
            }

            .type-container{
                position: relative;
                font-size: 1.8rem;
                display: flex;
                justify-content: center;  
                align-items: center;
            }

            #line{
                position: relative;
            }

            .cursor{
                height: 2rem;
                width: 2px;
                margin-left:2px;
                background: rgba(255,255,255,.75);
                animation: blinkTextCursor 800ms infinite;
            }

            @keyframes blinkTextCursor{
                from{opacity: 1;}
                to{opacity: 0;}
            }

        </style>
    </head>
    <body>
        <div id="dvi1">
            <%
                int seq = analysisDTO.Cutter_(); //this cuts the total into 500 per batch to manage server resources

                int total_cnt = seq * 500;

            %>
<h2>Welcome to analytics processor!</h2><br>
             <h4>Total data to be processed and match = <%= total_cnt%></h4>
            <h4 id="work">we are working on it...</h4>
            
             <h4 id="workx">When the loading image appears, you are safe to push the job into background.</h4>
             <a id="myImg" style ="display: none;" href="../fhir_frontend/OrgToolOperation.jsp?doneanalyse=background"><img  src="./loaing.gif" alt="loading..." width="304" height="228"></a> 
        </div>
        <hr>
        <p></p>
        
        <div class="type-container">

            <p id="line"></p>
            <div class="cursor"></div>
        </div>
    </body>
    <script>

        var line = document.getElementById("line")
                var txts = ["This process might take a while... lets crack some jokes!", "1.There are two types of people in the world:", "those who understand binary, and those who don't.",
                        "2. How many programmers does it take to change a light bulb?",
                        "None. It's a hardware problem.",
                        "3. A SEO couple had twins. For the first time they were happy with duplicate content.",
                        "4. Why is it that programmers always confuse Halloween with Christmas?",
                        "Because 31 OCT = 25 DEC",
                        "5. Why do they call it hyper text?",
                        "Too much JAVA.",
                        "6. Why was the JavaScript developer sad?", "Because he didn't Node how to Express himself",
                        "7. In order to understand recursion you must first understand recursion.",
                        "8. Why do Java developers wear glasses? Because they can't C#",
                        "9. What do you call 8 hobbits?",
                        "A hobbyte",
                        "10. Why did the developer go broke?",
                        "Because he used up all his cache",
                        "11. Why did the geek add body { padding-top: 1000px; } to his Facebook profile?",
                        "He wanted to keep a low profile.",
                        "12. An SEO expert walks into a bar, bars, pub, tavern, public house, Irish pub, drinks, beer, alcohol",
                        "13. I would tell you a UDP joke, but you might not get it.", "14. 8 bytes walk into a bar, the bartenders asks 'What will it be?'",
                        "One of them says, 'Make us a double.'",
                        "15. Two bytes meet. The first byte asks, Are you ill?'",
                        "The second byte replies, 'No, just feeling a bit off.'",
                        "16. These two strings walk into a bar and sit down. The bartender says, 'So what'll it be?'",
                        "The first string says, 'I think I'll have a beer quag fulk boorg jdk^CjfdLk jk3s d#f67howe%^U r89nvy~~owmc63^Dz x.xvcu'",
                        "Please excuse my friend, the second string says, 'He isn't null-terminated.'",
                        "17. 'Knock, knock. Who's there?'",
                        "very long pause...",
                        "Java.",
                        "18. If you put a million monkeys on a million keyboards, one of them will eventually write a Java program. The rest of them will write Perl programs.",
                        "19. There's a band called 1023MB. They haven't had any gigs yet.",
                        "20. There are only two hard things in computer science: cache invalidation, naming things, and off-by-one errors."];
        var speed = 50
                var speedx = 20

                async function typewriter(txt) {
                for (let i = 0; i < txt.length; i++){
                line.innerHTML += txt.charAt(i);
                await delay(speed)
                }
                }

        async function reverseTypewriter(txt) {
        for (let i = txt.length; i > 0; i--){
        line.innerHTML = line.innerHTML.slice(0, - 1)
        
                await delay(speedx)
                
        }
        setTimeout(function(){
        var dd = document.getElementById("work").innerHTML = "We are still working on it..."
    },1000);
        }

        async function writeLoop(){

        for (let i = 0; i < txts.length; i++){
        await typewriter(txts[i])
                await delay(4000)
                await reverseTypewriter(txts[i])
                await delay(1000)
        }

        writeLoop()
        }
        function delay(ms){
            
        return new Promise((resolve) => {setTimeout(() => {resolve()}, ms)})
        }

        writeLoop()

 setTimeout(function(){
        var x = document.getElementById("myImg").style.display = "block";
        var x = document.getElementById("workx").innerHTML = "IT IS NOW SAFE TO WORK IN BACKGROUND, CLICK ON THE LOADING IMAGE";
    },5000);
    
    setTimeout(function(){
        var dd = document.getElementById("work").innerHTML = "Bear with us... this is taking time..."
    },15000);
    
     setTimeout(function(){
        var dd = document.getElementById("work").innerHTML = "hmmm almost there..."
    },40000);
    
     setTimeout(function(){
        var dd = document.getElementById("work").innerHTML = "finishing up"
    },90000);
        
    
location.replace("dummy_processor.jsp");
    </script>

    
</html>
