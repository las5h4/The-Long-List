# The-Long-List

*The Long List* is a dynamic web app for generating grocery lists based on long-term meal plans. This project utilizes tech stack including MySQL, Java, Spring Boot and Thymeleaf templates.

## Functionality
Users complete workflows which allow them to customize their own ingredients based on the meals and courses they are planning. All plans, meals, courses, ingredients and grocery lists are saved to the user’s profile through a robust database featuring a variety of persistent relationships.

### The Log-in Page

#### Figure 1
![Log-in view](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig1_login.png)
Users must be logged in to access the features of the website. If they are not a registered user, there is a link which allows them to do so. User authentication is performed using Spring Security.

### The Home Page

#### Figure 2
![Home page view](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig2_homepage.png)
Once a user has successfully logged in, they are brought to the home page. The top of this page has a simple nav bar which allows the user to access their plans and lists if they have already created them. Underneath the personalized message is a button labeled "Get Started" which directs both new and returning users to the beginning of the workflow for creating new meal plans (or just **Plans**) and generating grocery **Lists**.

### *My Plans*

#### Figure 3
![My Plans view](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig3_myplans.png)
Both the "Get Started" button and the "My Plans" option in the nav bar from the home page (figure 2) will direct the user to the *My Plans* page (figure 3). If the user has made **Plans** on *The Long List* before, they will see links to their previous **Plans** on this page. Following these links will allow the user to edit these **Plans** and create new **Lists**. At the botttom of the list of **Plans**, there is a button which allows the user to start a new **Plan**.   

### Creating a New **Plan**

#### Figure 4
![New Plan View](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig4_startnewplan.png)
#### Figure 5
![Plan View](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig5_planview.png)
Upon clicking the "Start a new Plan" button on the *My Plans* page (figure 3), the user is directed to a page which allows them to name their new **Plan** and determine the length of the **Plan** in days (figure 4). For the purpose of this demonstration, our user has decided to make a **Plan** for one week (7 days), and they have named their **Plan** "One Week Plan." When they click the "Next" button, they are directed to the main page for that specific **Plan**\* (figure 5). On this page, the user will see a list of links corresponding to each **Day** of their **Plan**. Because our user said they were planning for 7 days, 7 **Days** have been created. The user can now click on the **Days** to add **Meals** to them.

\* - It is worth noting that if a returning user clicks on one of the links on the *My Plans* page (figure 3), they will also be directed to that **Plan's** main page (figure 5).

### Adding **Meals**

#### Figure 6
[Empty Day view](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig6_dayviewnomeals.png)
When a user clicks on a **Day** in a new **Plan**, they will see a page that identifies the **Day** which they have chosen to edit, and the option to add a new **Meal** or return to the **Plan's** main page. As a user adds **Meals**, they will also see a list of links to those **Meals** in this view.

#### Figure 7
[New Meal view](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig7_addnewmeal.png)
The user will be prompted to create a name for their new **Meal**. This name should be something that distinguishes this **Meal** from other **Meals** created within the same day, and can range from generic (e.g. "Breakfast") to more specific (e.g. "Logan's Lunch").

#### Figure 8
[Meal view with no courses](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig8_mealviewnocourses.png)
**Meals** are made up of **Courses**, which are made up of specific **Ingredients** that are used to make those **Courses**. When a user creates a **Course**, it is saved to their profile and can be accessed via the drop-down menu when creating **Meals**. This user has already created a **Course** called "Fried Eggs," which presumably contains **Ingredients** like eggs, oil, salt, and pepper. The user selects "Fried Eggs" from the drop-down menu and clicks "Add Course" to add this **Course** to the **Meal**, "Breakfast" (as seen in Figure 9)

#### Figure 9
[Meal with course "Fried Eggs" added](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig9_mealviewexistingcourse.png)
Now our user would like to add the **Course** "French Toast" to their **Meal**. However, this **Course** is not an option in the drop-down menu because the user has not created it yet. To create a new **Course**, the user clicks the "Create a new Course" button on the bottom of the page.

#### Figure 10
[New Course view](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig10_newcourseview.png)
#### Figure 11
[Course view with no ingredients](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig11_courseviewnoingredients.png)
#### Figure 12
[Ingredients drop-down menu](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig12_ingredientdropdown.png)
#### Figure 13
[Course view with some ingredients](https://github.com/las5h4/The-Long-List/blob/master/Figures/TLL_fig13_courseviewexistingingredients.png)
To create a new **Course**, the user must create a unique name and add at least one **Ingredient** required to make it. The user types the name and clicks the "Add Ingredients" button (figure 10) and is directed to a view which allows them to add **Ingredients** to their new **Course** (figure 11). The **Ingredients** drop-down menu (figure 12) contains all **Ingredients** that have been created by any *The Long List* users. This allows our user to easily add some of the **Ingredients** they need to make French Toast! The **Ingredients** "Bread", "Eggs", and "Milk" are already in the **Ingredients** drop-down menu and are added (figure 13). 

#### Figure 14
[
