package com.kamil.springbootstarter.topics;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>( Arrays.asList(
            new Topic( "spring", "spring framework", "descritpin" ),
            new Topic( "java", "java framework", "java description" ),
            new Topic( "script", "some name", "some descr" )
    ) );


    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter( t -> t.getId().equals( id ) ).findFirst().get();

    }

    public void addTopic(Topic topic) {
        topics.add( topic );

    }

    public void updateTopic(Topic topic, String id) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get( i );
            if (t.getId().equals( id )) {
                topics.set( i, topic );
                return;
            }

        }
    }

    public void deleteTopic(String id) {
        topics.removeIf( t -> t.getId().equals( id ) );
    }
}
