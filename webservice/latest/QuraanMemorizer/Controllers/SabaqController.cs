using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using QuraanMemorizer.Models;
using QuraanMemorizer.DAL;

namespace QuraanMemorizer.Controllers
{
    public class SabaqController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET api/Sabaq
        public IQueryable<Sabaq> GetSabaq()
        {
            return db.Sabaq;
        }

        // GET api/Sabaq/5
        [ResponseType(typeof(Sabaq))]
        public IHttpActionResult GetSabaq(int id)
        {
            Sabaq sabaq = db.Sabaq.Find(id);
            if (sabaq == null)
            {
                return NotFound();
            }

            return Ok(sabaq);
        }

        // PUT api/Sabaq/5
        public IHttpActionResult PutSabaq(int id, Sabaq sabaq)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != sabaq.Guid)
            {
                return BadRequest();
            }

            db.Entry(sabaq).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SabaqExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST api/Sabaq
        [ResponseType(typeof(Sabaq))]
        public IHttpActionResult PostSabaq(Sabaq sabaq)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Sabaq.Add(sabaq);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = sabaq.Guid }, sabaq);
        }

        // DELETE api/Sabaq/5
        [ResponseType(typeof(Sabaq))]
        public IHttpActionResult DeleteSabaq(int id)
        {
            Sabaq sabaq = db.Sabaq.Find(id);
            if (sabaq == null)
            {
                return NotFound();
            }

            db.Sabaq.Remove(sabaq);
            db.SaveChanges();

            return Ok(sabaq);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool SabaqExists(int id)
        {
            return db.Sabaq.Count(e => e.Guid == id) > 0;
        }
    }
}