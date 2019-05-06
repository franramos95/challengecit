# **Welcome to the CI&T QA's Challenge**
Hey there! We are very proud to have you here!

At first, congratulations to be elected for this challenge. It's important to mention that we have created this project to assess your level of comprehension in software testing and automation. Keep in mind that our evaluation goes beyond the 'working code'. We want to see how well you organize yourself, your code and your time.

Important notes:

1. Do not worry about writing too much code. Sometimes, less is more.
2. We'll evaluate your code even if it's not totally running.
3. Feel free to contact us in case of questions.
4. Read with attention to all the instructions in the section **Instructions** below before pushing it.

**What do we expect to see?**

- QA mindset! Do as you do in your day: identify tests cases!
- Tests in English features and steps based in BDD (choose Ruby, Python or Java). **You don't need to be an automation expert**, we want to check how much you already know or can find out how to do.
- Even if you don't have enough time, or if you don't know how to do all the challenge, we will analyze **anything** that you deliver.

So good luck! We are looking forward to having you here with us!

---

## **Instructions**

### **Setup**

- Clone this project into your machine.
- Create a branch name with your BitBucket username.
- Check out the new branch.
- Make your changes as requested in section **Challenges**.

Any access issue, send to danielef@ciandt.com.

### **Steps to send your solution**
- When finished, create a pull request. Put the user **danielef_cit** as the pull request reviewer.
- Wait for our evaluation and contact.

Breath, relax first and good work!

---

## Challenges

### **Manual Tests**
On "manual_tests" folder, include one or more files with at least 10 test cases to check this page http://automationpractice.com/index.php.

Be free to use Gherkin or plain text.

### **Automated Tests**
On "automated_tests" folder, using Cucumber on any language you want, include your source code to test JSON Place Holder API, considering:

Host: https://jsonplaceholder.typicode.com/

Fill free to include other validations.

*GET /users*
```
1. All users must have a name, username, and email.

2. Their Email must be valid.
    
3. Their Company catchphrase must have less than 50 characters.
```

*POST /posts*
```
1. Save a new post using a userId got by "GET /users" API.

2. When trying to save a new post without the title, API must return an error.
```

### **Extra Tests**
If you want, create a new folder on this repository and include a SoapUI project or a Postman project doing the same tests done on "Automated Tests" session.
