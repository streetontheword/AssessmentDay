package sdf.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Locale.Category;
import java.util.stream.Collectors;

public class Main {

    static double rating;

    public static void main(String[] args) throws Exception {

        final int COL_NAME = 0;
        final int COL_CATEGORY = 1;
        final int COL_RATING = 2;

        // check if file is there first
        if (args.length < 0) {
            System.err.println("Missing csv file ");
            System.exit(1);
        }

        System.out.printf("Processing: %s\n", args[0]);

        // now read the file
        try (FileReader fr = new FileReader(args[0])) {
            BufferedReader br = new BufferedReader(fr);
            // br.readLine()

            Map<String, List<Application>> grouped = br.lines()
                    .skip(1)
                    // String -> String[]
                    .map(row -> row.trim().split(","))
                    // String[] -> Application object
                    // we want to extract the 0,1, and 2nd column
                    .map(fields -> new Application(fields[COL_NAME], fields[COL_CATEGORY], fields[COL_RATING]))
                    // grouping by takes a function and returns a value. then you tell the grouping
                    // by where does this value belong to,
                    // grouping by will return a map
                    .collect(Collectors.groupingBy(apps -> apps.getCategory()));

            // outer loop
            for (String category : grouped.keySet()) {
                System.out.printf("\n Category: %s\n", category);
                List<Application> apps = grouped.get(category);
                List<Application> rejectedApplications = new ArrayList<>();
                List<Application> acceptedApplications = new ArrayList<>();
                
                System.out.printf("Count of %s applications : %d\n", category, apps.size());

                // innner loop

                for (Application app : apps)
                    // app.getRating is the rating for every single app categorised by category
                    // we want to compare if the rating has "NaN"
                    // if it does, add it to the rejected list
                    // if not, add to the accepted list

                    if ("NaN".equals(app.getRating())) {
                        rejectedApplications.add(app);
                    } else {
                        acceptedApplications.add(app);
                    }
                System.out.printf("Discarded : %d\n", rejectedApplications.size());
            }
           
          
        }


        // to get the average, you need to get the total of the ratings and divide it by
        // the count

    }

    // loop through the list, if it is higher than count, it will equal to .getrating
    public void getHighest(List<Application> listofApplications) {
        double count = 0;
        String name = "";
       
        for (Application app : apps) {
            double value = Double.parseDouble(app.getRating());
            if (value > count) {
                count = value;
            }
        }

        Application highestApplication = new Application();

        // compare all the ratings of the book with the double count
        // if it is higher, then replace it

    }

    public void getLowest(List<Application> listofApplications) {
        double count = 0;
        String name = "";
         for (Application app : apps) {
            double value = Double.parseDouble(app.getRating());
            if (value < count) {
                count = value;
            }
        }
        Application lowesApplication = new Application();

    }


    public void getAverage(List<Application> averageOfApplications) {

    }
}

    
