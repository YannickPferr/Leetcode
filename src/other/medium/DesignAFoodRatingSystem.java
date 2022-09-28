package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 2353. Design a Food Rating System
    * Difficulty: Medium
    * Link: https://leetcode.com/problemsdesign-a-food-rating-system
    */
    class FoodRatings {

    class Food {
        String cuisine;
        String name;
        int rating;
        
        public Food(String name, int rating, String cuisine){
            this.name = name;
            this.rating = rating;
            this.cuisine = cuisine;
        }
        
        public String toString(){
            return "{" + name + ", " + rating + "}";
        }
    }
    
    HashMap<String, PriorityQueue<Food>> cuisines = new HashMap<>();
    HashMap<String, Food> foodMap = new HashMap<>();
    HashMap<String, Integer> latestRating = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++){
            Food food = new Food(foods[i], ratings[i], cuisines[i]);
            PriorityQueue<Food> f = this.cuisines.getOrDefault(cuisines[i], new PriorityQueue<>((f1, f2) -> f2.rating == f1.rating ? f1.name.compareTo(f2.name) : f2.rating - f1.rating));
            f.add(food);
            this.cuisines.put(cuisines[i], f);
            
            foodMap.put(foods[i], food);
            latestRating.put(foods[i], ratings[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food f = foodMap.get(food);
        PriorityQueue<Food> foods = cuisines.get(f.cuisine);
        foods.add(new Food(f.name, newRating, f.cuisine));
        latestRating.put(food, newRating);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> foods = cuisines.get(cuisine);
        Food best = foods.poll();
        while(best.rating != latestRating.get(best.name))
            best = foods.poll();
        foods.add(best);
        return best.name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */