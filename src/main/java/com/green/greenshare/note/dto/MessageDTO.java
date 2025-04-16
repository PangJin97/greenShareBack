package com.green.greenshare.note.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
  private String senderEmail;
  private String receiverEmail;
  private String content;
  private int id;
  private LocalDateTime sentAt;
}
