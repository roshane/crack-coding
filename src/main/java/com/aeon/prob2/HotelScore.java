package com.aeon.prob2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by roshane on 7/18/17.
 */
public class HotelScore {

    static class Hotel {
        int id;
        int userId;
        int score;
        int reviewCount = 1;
        int totScore;

        Hotel(int id, int userId, int score) {
            this.id = id;
            this.userId = userId;
            this.score = score;
            totScore = score;
        }

        void addReview() {
            this.reviewCount += 1;
        }

        void addScore(int i) {
            totScore += i;
        }

        @Override
        public String toString() {
            return "Hotel{" +
                    "id=" + id +
                    ", userId=" + userId +
                    ", score=" + score +
                    ", reviewCount=" + reviewCount +
                    ", totScore=" + totScore +
                    '}';
        }
    }

    public static void main(String[] args) {
//        findMissingElement();
        int k=2;
        int[] a={1,2,3,4,5};
        System.out.println(Arrays.toString(a));
        reverseArray(a,0,k);
        System.out.println(Arrays.toString(a));
        reverseArray(a,k+1,a.length-1);
        System.out.println(Arrays.toString(a));
        reverseArray(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void hotelThing() {
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(new Hotel(1001, 501, 7));
        hotelList.add(new Hotel(1001, 502, 7));
        hotelList.add(new Hotel(1001, 503, 7));
        hotelList.add(new Hotel(2001, 504, 10));
        hotelList.add(new Hotel(3001, 505, 5));
        hotelList.add(new Hotel(2001, 506, 5));


        Map<Integer, Hotel> hotelData = new HashMap<>();
        hotelList.forEach(hotel -> {
            if (!hotelData.containsKey(hotel.id)) {
                hotelData.put(hotel.id, hotel);
            } else {
                Hotel h = hotelData.get(hotel.id);
                h.addReview();
                h.addScore(hotel.score);
            }
        });

        final int minAvgScore = 7;
        List<Integer> hotelIds = hotelData.entrySet()
                .stream()
                .filter(e -> {
                    Hotel h = e.getValue();
                    int avgScore = h.totScore / h.reviewCount;
                    return avgScore >= minAvgScore;
                }).map(Map.Entry::getValue)
                .map(h -> h.id)
                .collect(Collectors.toList());

        System.out.println(hotelIds);
    }

    static void findMissingElement() {
        int a[] = {1, 2, 3, 4, 6, 5};
        int b[] = {1, 2, 3, 4, 5};

        int[] longest;
        int[] shortest;

        if (a.length > b.length) {
            longest = a;
            shortest = b;
        } else {
            longest = b;
            shortest = a;
        }
        int result=0;
        for(int i=0;i<longest.length;i++){
            result^=longest[i];
            if(i<shortest.length){
                result^=shortest[i];
            }
        }
        System.out.println("missing: "+result);
    }

    static void reverseArray(int[] a,int start,int end){
        while (start<end){
            swap(a,start,end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
