package com.green.greenshare.note.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageDTO {
  private String senderEmail;
  private String receiverEmail;
  private String content;
  private int id;
  private LocalDateTime sentAt;
}
