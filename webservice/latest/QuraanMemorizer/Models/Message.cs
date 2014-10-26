using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace QuraanMemorizer.Models
{
    public class Message
    {
        public int Id { get; set; }

        [DataType(DataType.Date)]

        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public DateTime MessageDate { get; set; }
        public string Messages { get; set; }
        public bool IsRead { get; set; }

        [Display(Name = "Message Sender")]
        public int SenderId { get; set; }

        public  ApplicationUser Sender { get; set; }

        public int RecieverId { get; set; }
        public ApplicationUser Reciever { get; set; }

        
    }
}