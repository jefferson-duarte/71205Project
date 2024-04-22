Name: Jefferson Duarte
ID: 71205

1. **Authentication**
   - ✅ 1.1 Allow User to Signup
   - ✅ 1.2 Log In using username and password
   - ❌ 1.3 Store userID once logged in to keep the user logged in (even after restarting the app)

2. **Product Listing**
   - ✅ 2.1 List Product Categories
   - ✅ 2.2 On clicking a Category, list Products in that Category
   - ✅ 2.3 On clicking a Product, show Product description, show buy button and controls to change quantity.

3. **Cart**
   - ✅ 3.1 Show cart summary
   - ✅ 3.2 Show total amount
   - ❌ 3.3 Purchase button to place an order, show order notification

4. **Show order history**
   - ❌ 4.1 List users orders
   - ❌ 4.2 On clicking an Order, show Order details and Products ordered
   - ❌ 4.3 On clicking a Product, take them to Product description page created for 2.3

5. **Show User details**
   - ❌ 5.1 Use the stored userID to show user details
   - ✅ 5.2 Show a random circular profile image
   - ❌ 5.3 Show Logout button, on click take back to Signup / Log In page (Restart should not auto login after logout)

6. **UI/Implementational Requirements**
   - ✅ 6.1 Lazy lists to be used for all Lists: Categories, Products, Orders
   - ❌ 6.2 If logged in, attach authentication token to all requests until logout
   - ✅ 6.3 Add a small "About this app" button in the profile page, that shows a page on click with your copyright details and credits

7. **Bonus**
   - ❌ 7.1 ViewPager2 with bottom TabLayout for: Shop, Cart, Orders, Profile icons
   - ❌ 7.2 Show a map fragment based on the GPS co-ordinates in the user profile	
